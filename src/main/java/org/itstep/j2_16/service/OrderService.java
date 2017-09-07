package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order save(Order order);
}
