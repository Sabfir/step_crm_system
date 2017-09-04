package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.ProductCategoryDao;
import org.itstep.j2_16.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return productCategoryDao.update(productCategory);
    }

    @Override
    public ProductCategory getById(long id) {
        return productCategoryDao.getById(id);
    }

}