package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.Order;
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
    public List<Order> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root<Order> variableRoot = query.from(Order.class);
        query.select(variableRoot);
        List<Order> orders = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return orders;
    }

    @Override
    public Order save(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Order savedOrder = (Order) session.merge(order);

        session.getTransaction().commit();
        session.close();

        return savedOrder;
    }
}
