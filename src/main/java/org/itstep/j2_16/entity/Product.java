package org.itstep.j2_16.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int barcode;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductCategory productCategory;

    @JsonGetter("productCategory")
    public long getProductCategoryForDto() {
        return productCategory.getId();
    }
}
