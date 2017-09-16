package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(long id);

    Employee save(Employee employee);

    Employee update(long id, Employee employee);

    public float calculateAnnualSalary(Employee employee);
}
