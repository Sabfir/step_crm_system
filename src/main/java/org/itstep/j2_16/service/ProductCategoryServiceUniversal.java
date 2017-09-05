package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.ProductCategoryDao;
import org.itstep.j2_16.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.lang.String.format;

@Service
public class ProductCategoryServiceUniversal implements ProductCategoryService {
    private ProductCategoryDao productCategoryDao;

    @Autowired
    public ProductCategoryServiceUniversal(ProductCategoryDao productCategoryDao){
        this.productCategoryDao = productCategoryDao;
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }

    @Override
    public ProductCategory getById(long id) {
        return productCategoryDao.getById(id);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory update(long id, ProductCategory productCategory) {
        if (getById(id) == null) {
            throw new RuntimeException(format("Product category by id %s not found", id));
        }

        productCategory.setId(id);
        productCategoryDao.update(productCategory);

        return productCategory;
    }
}
