package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.OrderDocument;

import java.util.List;

public interface OrderService {

    List<OrderDocument> getAll();

    OrderDocument save(OrderDocument order);
}
