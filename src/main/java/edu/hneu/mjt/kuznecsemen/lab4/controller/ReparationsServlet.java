package edu.hneu.mjt.kuznecsemen.lab4.controller;

import edu.hneu.mjt.kuznecsemen.lab4.entity.PhoneReparationInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet("/")
public class ReparationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<PhoneReparationInfo> reparations = entityManager
                    .createQuery("SELECT r FROM PhoneReparationInfo r", PhoneReparationInfo.class).getResultList();
            req.setAttribute("reparations", reparations);
            req.getRequestDispatcher("reparations.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
