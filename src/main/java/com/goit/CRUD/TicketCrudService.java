package com.goit.CRUD;

import com.goit.Ticket;
import com.goit.Client;
import com.goit.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TicketCrudService {

    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket createTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        }
    }

    public Ticket getTicketById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket", Ticket.class);
            return query.list();
        }
    }

    public Ticket updateTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
            return ticket;
        }
    }

    public void deleteTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

    public List<Ticket> getTicketsByClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket WHERE client = :client", Ticket.class);
            query.setParameter("client", client);
            return query.list();
        }
    }

    public List<Ticket> getTicketsByFromPlanet(Planet fromPlanet) {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket WHERE fromPlanet = :fromPlanet", Ticket.class);
            query.setParameter("fromPlanet", fromPlanet);
            return query.list();
        }
    }

    public List<Ticket> getTicketsByToPlanet(Planet toPlanet) {
        try (Session session = sessionFactory.openSession()) {
            Query<Ticket> query = session.createQuery("FROM Ticket WHERE toPlanet = :toPlanet", Ticket.class);
            query.setParameter("toPlanet", toPlanet);
            return query.list();
        }
    }
}