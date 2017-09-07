package org.itstep.j2_16.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    private String name;
    private int barcode;

    @JsonGetter("productCategory")
    public long getOrderForDto() {
        return productCategory.getId();
    }
}
