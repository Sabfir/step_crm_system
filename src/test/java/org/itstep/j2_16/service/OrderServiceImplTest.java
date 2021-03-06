package org.itstep.j2_16.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.itstep.j2_16.dao.OrderDao;
import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.OrderItem;
import org.junit.Test;
import org.mockito.Mockito;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.exparity.hamcrest.date.LocalDateTimeMatchers.sameOrAfter;
import static org.exparity.hamcrest.date.LocalDateTimeMatchers.sameOrBefore;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {
    OrderDao orderDaoMock = Mockito.mock(OrderDao.class);
    private OrderService orderServiceMock = new OrderServiceImpl(orderDaoMock);

    @Test
    public void save() {
        // given
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem());
        orderItems.add(new OrderItem());
        order.setOrderItems(orderItems);

        LocalDateTime dateStart = now();

        when(orderDaoMock.save(order)).thenReturn(order);

        // when
        orderServiceMock.save(order);

        LocalDateTime dateEnd = now();

        // then
        assertThat(order.getCreated(), sameOrAfter(dateStart));
        assertThat(order.getCreated(), sameOrBefore(dateEnd));

        Mockito.verify(orderDaoMock, Mockito.times(1)).save(order);
    }




//    @Test
//    public void getAll() throws Exception {
//        Order order = new Order();
//        order.addOrderItem(new OrderItem());
//        order.addOrderItem(new OrderItem());
//        List<Order> orders = singletonList(order);
//
//        // given
//        OrderService orderServiceMock = mock(OrderService.class);
//        when(orderServiceMock.getAll()).thenReturn(orders);
//
//        // when
//        List<Order> foundOrders = orderServiceMock.getAll();
//
//        // than
//        assertThat("The return list is not as expected", foundOrders, equalTo(orders));
//        verify(orderServiceMock, times(1)).getAll();
//    }
//
//
//    @Test
//    public void fillBeforeSaving() throws Exception {
//        // given
//        Order order = new Order();
//        order.addOrderItem(new OrderItem());
//        order.addOrderItem(new OrderItem());
//
//        LocalDateTime dateStart = now();
//
//        // when
//        orderService.fillBeforeSaving(order);
//
//        // than
//        LocalDateTime dateEnd = now();
//        String message = format("Date of creation should be before %s and %s", dateStart, dateEnd);
//        assertThat(message, order.getCreated(), sameOrAfter(dateStart));
//        assertThat(message, order.getCreated(), sameOrBefore(dateEnd));
//
//        message = "Every item should have order filled";
//        assertThat(message, order.getOrderItems(), everyItem(hasProperty("order", equalTo(order))));
//    }
}