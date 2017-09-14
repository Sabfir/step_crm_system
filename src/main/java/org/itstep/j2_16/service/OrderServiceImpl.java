package org.itstep.j2_16.service;

import lombok.extern.slf4j.Slf4j;
import org.itstep.j2_16.dao.OrderDao;
import org.itstep.j2_16.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAll() {
        log.info("Getting all orders");
        return orderDao.getAll();
    }

    @Override
    public Order save(Order order) {
        log.info("Creating order");
       // fillBeforeSaving(order);
        order.setCreated(now());
        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        return orderDao.save(order);
    }

    @Override
    public void fillBeforeSaving(Order order) {
        order.setCreated(now());
        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
    }
}
