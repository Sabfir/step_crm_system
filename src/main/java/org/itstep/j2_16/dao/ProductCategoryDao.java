package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> getAll();

    ProductCategory getById(long id);

    ProductCategory save(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);
}
