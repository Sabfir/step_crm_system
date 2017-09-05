package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAll();

    OrderItem save(OrderItem orderItem);
}
