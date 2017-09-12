package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClientDaoUniversal implements ClientDao {
    private SessionFactory sessionFactory;

    @Autowired
    public ClientDaoUniversal(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> variableRoot = query.from(Client.class);
        query.select(variableRoot);
        List<Client> client = session.createQuery(query).getResultList();
        session.getTransaction().commit();
        session.close();
        return client;
    }

    @Override
    public Client getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.getTransaction().commit();
        session.close();
        return client;
    }

    @Override
    public Client save(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client savedClient = (Client)session.merge(client);
        session.getTransaction().commit();
        session.close();
        return savedClient;
    }

    @Override
    public void update(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }

}
