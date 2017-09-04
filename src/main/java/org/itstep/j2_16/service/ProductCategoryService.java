package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();

    ProductCategory getById(long id);

    ProductCategory save(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);
}
