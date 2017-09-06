package org.itstep.j2_16.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.j2_16.entity.Employee;
import org.itstep.j2_16.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> variableRoot = query.from(Employee.class);
        query.select(variableRoot);
        List<Employee> employees = session.createQuery(query).getResultList();

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    @Override
    public Employee getById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee savedEmployee = (Employee) session.merge(employee);

        session.getTransaction().commit();
        session.close();

        return savedEmployee;
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }
}
