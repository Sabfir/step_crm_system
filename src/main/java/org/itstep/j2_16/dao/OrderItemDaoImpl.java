package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    private SessionFactory sessionFactory;

    @Autowired
    public OrderItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<OrderItem> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderItem> query = builder.createQuery(OrderItem.class);
        Root<OrderItem> variableRoot = query.from(OrderItem.class);
        query.select(variableRoot);
        List<OrderItem> orders = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return orders;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        OrderItem savedOrderItem = (OrderItem) session.merge(orderItem);

        session.getTransaction().commit();
        session.close();

        return savedOrderItem;
    }
}
