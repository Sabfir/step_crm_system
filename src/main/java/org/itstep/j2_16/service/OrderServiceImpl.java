package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.OrderDao;
import org.itstep.j2_16.entity.OrderDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<OrderDocument> getAll() {
        return orderDao.getAll();
    }

    @Override
    public OrderDocument save(OrderDocument order) {
        return orderDao.save(order);
    }
}
