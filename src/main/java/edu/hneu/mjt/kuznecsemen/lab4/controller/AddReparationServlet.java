package edu.hneu.mjt.kuznecsemen.lab4.controller;

import edu.hneu.mjt.kuznecsemen.lab4.entity.PhoneReparationInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

@WebServlet("/add-reparation")
public class AddReparationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        var phoneReparationInfo = new PhoneReparationInfo();

        phoneReparationInfo.setTitle(request.getParameter("title"));
        phoneReparationInfo.setManufacturer(request.getParameter("manufacturer"));
        phoneReparationInfo.setModel(request.getParameter("model"));
        phoneReparationInfo.setPlatform(request.getParameter("platform"));
        phoneReparationInfo.setCamera(Boolean.parseBoolean(request.getParameter("camera")));
        phoneReparationInfo.setInternet(request.getParameter("internet"));
        phoneReparationInfo.setGpsModule(Boolean.parseBoolean(request.getParameter("gpsModule")));
        phoneReparationInfo.setRecorder(Boolean.parseBoolean(request.getParameter("recorder")));
        phoneReparationInfo.setPrice(Float.parseFloat(request.getParameter("price")));
        phoneReparationInfo.setOptPrice(Float.parseFloat(request.getParameter("optPrice")));
        phoneReparationInfo.setUserLastName(request.getParameter("userLastName"));
        phoneReparationInfo.setUserEmail(request.getParameter("userEmail"));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PhoneReparationInfo>> violations = validator.validate(phoneReparationInfo);

        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            return;
        }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(phoneReparationInfo);
            transaction.commit();
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Помилка: " + e.getMessage());
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
