package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAll();

    Order save(Order order);
}
