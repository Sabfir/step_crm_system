package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.OrderDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<OrderDocument> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderDocument> query = builder.createQuery(OrderDocument.class);
        Root<OrderDocument> variableRoot = query.from(OrderDocument.class);
        query.select(variableRoot);
        List<OrderDocument> orders = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return orders;
    }

    @Override
    public OrderDocument save(OrderDocument order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        OrderDocument savedOrder = (OrderDocument) session.merge(order);

        session.getTransaction().commit();
        session.close();

        return savedOrder;
    }
}
