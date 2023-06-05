package com.goit.CRUD;

import com.goit.Client;
import com.goit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientCrudService {

    public void createClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(client);
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

    public Client getClientById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;

        try {
            client = session.get(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return client;
    }
    public void deleteClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(client);
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