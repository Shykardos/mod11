package com.goit.CRUD;

import com.goit.Planet;
import com.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCrudService {

    public void createPlanet(Planet planet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Planet getPlanetById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Planet planet = null;

        try {
            planet = session.get(Planet.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return planet;
    }
    public void deletePlanet(Planet planet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
