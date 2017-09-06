package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.OrderDocument;

import java.util.List;

public interface OrderDao {

    List<OrderDocument> getAll();

    OrderDocument save(OrderDocument order);
}
