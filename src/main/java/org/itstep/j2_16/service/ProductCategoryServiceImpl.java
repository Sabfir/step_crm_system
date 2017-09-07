package org.itstep.j2_16.service;

import lombok.extern.slf4j.Slf4j;
import org.itstep.j2_16.dao.ProductCategoryDao;
import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.ProductCategory;
import org.itstep.j2_16.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryDao productCategoryDao;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao) {
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
    public ProductCategory update(long id, ProductCategory productCategory) {
        if (getById(id) == null) {
            throw new RuntimeException(format("Product category by id %s not found", id));
        }

        productCategory.setId(id);
        productCategoryDao.update(productCategory);

        return productCategory;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        log.info("Creating ProductCategory communication");
        fillOrderBeforeSaving(productCategory);
        return productCategoryDao.save(productCategory);
    }

    private void fillOrderBeforeSaving(ProductCategory productCategory) {
        productCategory.getProducts().forEach(Product -> Product.setProductCategory(productCategory));
    }
}
