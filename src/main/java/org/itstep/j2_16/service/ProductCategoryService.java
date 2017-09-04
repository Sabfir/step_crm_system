package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.ProductCategory;
import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();

    ProductCategory save(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);

    ProductCategory getById(long id);
}
