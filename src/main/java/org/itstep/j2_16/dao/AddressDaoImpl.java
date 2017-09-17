package org.itstep.j2_16.dao;

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
        return session.get(Address.class, id);
    }

    @Override
    public Address save(Address address) {
        Session session = sessionFactory.openSession();
        return  (Address) session.merge(address);
    }

    @Override
    public void update(Address address) {
        Session session = sessionFactory.openSession();
        session.update(address);
    }
}
