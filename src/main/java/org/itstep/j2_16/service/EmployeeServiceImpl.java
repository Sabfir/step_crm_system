package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.EmployeeDao;
import org.itstep.j2_16.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.lang.String.format;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getById(long id) {
        return employeeDao.getById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee update(long id, Employee employee) {
        if (getById(id) == null) {
            throw new RuntimeException(format("Employee by id %s not found", id));
        }

        employee.setId(id);
        employeeDao.update(employee);

        return employee;
    }

    @Override
    public float calculateYearlySalary(Employee employee) {
        float yearlySalary = 0;
        yearlySalary = employee.getSalary() * 12;
        return yearlySalary;
    }
}
