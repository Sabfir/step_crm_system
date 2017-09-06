package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.OrderDocument;
import org.itstep.j2_16.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), OK);
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody OrderDocument order) {
        return new ResponseEntity<>(orderService.save(order), OK);
    }
}
