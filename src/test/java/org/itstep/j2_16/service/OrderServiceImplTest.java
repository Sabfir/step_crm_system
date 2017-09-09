package org.itstep.j2_16.service;

import java.time.LocalDateTime;
import org.hamcrest.CoreMatchers;
import org.itstep.j2_16.entity.Order;
import org.itstep.j2_16.entity.OrderItem;
import org.junit.Test;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static org.exparity.hamcrest.date.LocalDateTimeMatchers.sameOrAfter;
import static org.exparity.hamcrest.date.LocalDateTimeMatchers.sameOrBefore;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertThat;

public class OrderServiceImplTest {
    private OrderService orderService = new OrderServiceImpl(null);

    @Test
    public void fillBeforeSaving() throws Exception {
        // given
        Order order = new Order();
        order.addOrderItem(new OrderItem());
        order.addOrderItem(new OrderItem());

        LocalDateTime dateStart = now();

        // when
        orderService.fillBeforeSaving(order);

        // than
        LocalDateTime dateEnd = now();
        String message = format("Date of creation should be before %s and %s", dateStart, dateEnd);
        assertThat(message, order.getCreated(), sameOrAfter(dateStart));
        assertThat(message, order.getCreated(), sameOrBefore(dateEnd));

        message = "Every item should have order filled";
        assertThat(message, order.getOrderItems(), everyItem(hasProperty("order", equalTo(order))));
    }
}