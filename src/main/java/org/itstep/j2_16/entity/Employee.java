package org.itstep.j2_16.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String firstName;
    private String lastName;
    private String sex;
    private int age;
    private String position;
    private double salary;
}
