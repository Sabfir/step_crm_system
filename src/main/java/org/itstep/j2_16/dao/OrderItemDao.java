package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {

    List<OrderItem> getAll();

    OrderItem save(OrderItem orderItem);
}
