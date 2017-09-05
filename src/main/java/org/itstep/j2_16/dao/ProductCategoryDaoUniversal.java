package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductCategoryDaoUniversal implements ProductCategoryDao {
    private SessionFactory sessionFactory;

    @Autowired
    public ProductCategoryDaoUniversal (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductCategory> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductCategory> query = builder.createQuery(ProductCategory.class);
        Root<ProductCategory> variableRoot = query.from(ProductCategory.class);
        query.select(variableRoot);
        List<ProductCategory> productCategories = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return productCategories;
    }

    @Override
    public ProductCategory getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ProductCategory productCategory = session.get(ProductCategory.class, id);

        session.getTransaction().commit();
        session.close();

        return productCategory;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ProductCategory savedProductCategory = (ProductCategory)session.merge(productCategory);

        session.getTransaction().commit();
        session.close();

        return savedProductCategory;
    }

    @Override
    public void update(ProductCategory productCategory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(productCategory);

        session.getTransaction().commit();
        session.close();
    }
}
