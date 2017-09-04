package org.itstep.j2_16.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    private String description;

}
