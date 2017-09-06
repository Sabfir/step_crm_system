package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.Employee;
import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    Employee getById(long id);

    Employee save(Employee employee);

    void update(Employee employee);
}
