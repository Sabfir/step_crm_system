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
    public List<Address> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> variableRoot = query.from(Address.class);
        query.select(variableRoot);
        List<Address> addresses = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return addresses;
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
}
