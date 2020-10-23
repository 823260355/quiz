package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity addOrder(@Valid @RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
