package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.EmployeeDao;
import org.itstep.j2_16.entity.Employee;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EmployeeServiceImplTest {
    EmployeeDao employeeDaoMock = Mockito.mock(EmployeeDao.class);
    private EmployeeService employeeServiceMock = new EmployeeServiceImpl(employeeDaoMock);

    @Test
    public void calculateAnnualSalary() {
        //given
        Employee employee = new Employee();
        employee.setSalary(1000F);

        //when
        float salary = employeeServiceMock.calculateAnnualSalary(employee);

        //then
        assertThat(12000F, equalTo(salary));
    }
}
