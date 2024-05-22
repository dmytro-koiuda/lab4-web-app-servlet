package edu.hneu.mjt.kuznecsemen.lab4.controller;

import edu.hneu.mjt.kuznecsemen.lab4.entity.PhoneReparationInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.Set;

@WebServlet("/edit-reparation")
public class UpdateReparationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            var reparation = entityManager.find(PhoneReparationInfo.class, id);
            if (reparation != null) {
                request.setAttribute("reparation", reparation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        request.getRequestDispatcher("updateReparation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        var updatedReparation = new PhoneReparationInfo();
        updatedReparation.setTitle(request.getParameter("title"));
        updatedReparation.setManufacturer(request.getParameter("manufacturer"));
        updatedReparation.setModel(request.getParameter("model"));
        updatedReparation.setPlatform(request.getParameter("platform"));
        updatedReparation.setCamera(Boolean.parseBoolean(request.getParameter("camera")));
        updatedReparation.setInternet(request.getParameter("internet"));
        updatedReparation.setGpsModule(Boolean.parseBoolean(request.getParameter("gpsModule")));
        updatedReparation.setRecorder(Boolean.parseBoolean(request.getParameter("recorder")));
        updatedReparation.setPrice(Float.parseFloat(request.getParameter("price")));
        updatedReparation.setOptPrice(Float.parseFloat(request.getParameter("optPrice")));
        updatedReparation.setUserLastName(request.getParameter("userLastName"));
        updatedReparation.setUserEmail(request.getParameter("userEmail"));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PhoneReparationInfo>> violations = validator.validate(updatedReparation);

        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            return;
        }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            var reparation = entityManager.find(PhoneReparationInfo.class, id);
            if (reparation != null) {
                reparation.setTitle(updatedReparation.getTitle());
                reparation.setManufacturer(updatedReparation.getManufacturer());
                reparation.setModel(updatedReparation.getModel());
                reparation.setPlatform(updatedReparation.getPlatform());
                reparation.setCamera(updatedReparation.isCamera());
                reparation.setInternet(updatedReparation.getInternet());
                reparation.setGpsModule(updatedReparation.isGpsModule());
                reparation.setRecorder(updatedReparation.isRecorder());
                reparation.setPrice(updatedReparation.getPrice());
                reparation.setOptPrice(updatedReparation.getOptPrice());
                reparation.setUserLastName(updatedReparation.getUserLastName());
                reparation.setUserEmail(updatedReparation.getUserEmail());
                entityManager.merge(reparation);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
