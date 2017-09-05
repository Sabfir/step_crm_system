package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDaoUniversal implements ProductDao{
    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoUniversal (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> variableRoot = query.from(Product.class);
        query.select(variableRoot);
        List<Product> product = session.createQuery(query).getResultList();
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product save(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product savedProduct = (Product)session.merge(product);
        session.getTransaction().commit();
        session.close();
        return savedProduct;
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

}
