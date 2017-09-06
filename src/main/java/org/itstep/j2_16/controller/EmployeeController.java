package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Employee;
import org.itstep.j2_16.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeServise;

    @Autowired
    public EmployeeController (EmployeeService employeeServise) {
        this.employeeServise = employeeServise;
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        return  new ResponseEntity<>(employeeServise.getAll(), OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable long id) {
        return new ResponseEntity<>(employeeServise.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee productCategory) {
        return new ResponseEntity<>(employeeServise.save(productCategory), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServise.update(id, employee), OK);
    }
}
