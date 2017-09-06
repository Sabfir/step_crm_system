package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.ProductDao;
import org.itstep.j2_16.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.lang.String.format;

@Service
public class ProductServiceUniversal implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductServiceUniversal(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(long id) {
        return productDao.getById(id);
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product update(long id, Product product) {
        Product foundProduct = getById(id);
        if (foundProduct == null) {
            throw new RuntimeException(format("Product by %s not found", id));
        }

        product.setId(id);
        productDao.update(product);

        return product;
    }

}
