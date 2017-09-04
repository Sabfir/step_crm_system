package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> getAll();

    ProductCategory save(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);

    ProductCategory getById(long id);
}
