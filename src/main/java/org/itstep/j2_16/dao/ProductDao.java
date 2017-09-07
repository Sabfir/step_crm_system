package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.Product;
import java.util.List;

public interface ProductDao {

    List<Product> getAll();

    Product getById(long id);

    Product save(Product product);

    void update(Product product);
}
