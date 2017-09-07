package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.OrderItemDao;
import org.itstep.j2_16.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao;

    @Autowired
    public OrderItemServiceImpl(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemDao.getAll();
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }
}
