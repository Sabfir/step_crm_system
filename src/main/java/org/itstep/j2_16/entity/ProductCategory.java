package org.itstep.j2_16.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    private String description;
    @OneToMany(fetch = EAGER, cascade = ALL, mappedBy = "productCategory")
    private List<Product> productItems;
}
