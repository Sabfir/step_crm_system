package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Product;
import java.util.List;


public interface ProductService {

    List<Product> getAll();

    Product getById(long id);

    Product save(Product product);

    Product update(long id, Product product);
}
