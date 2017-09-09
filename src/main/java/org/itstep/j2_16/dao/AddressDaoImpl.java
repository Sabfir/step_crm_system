package org.itstep.j2_16.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao {
    private SessionFactory sessionFactory;

    @Autowired
    public AddressDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Address getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = session.get(Address.class, id);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    @Override
    public Address save(Address address) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Address savedAddress = (Address) session.merge(address);

        session.getTransaction().commit();
        session.close();

        return savedAddress;
    }

    @Override
    public void update(Address address) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(address);
        session.getTransaction().commit();
        session.close();
    }
}
