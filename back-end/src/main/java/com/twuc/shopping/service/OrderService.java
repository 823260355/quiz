package com.twuc.shopping.service;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository ;

    public void addOrder(Order order) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(order.getId());
       if (orderEntity.isPresent()){
           OrderEntity orderEntity1 = orderEntity.get();
           orderEntity1.setAmount(orderEntity.get().getAmount() +1 );
           orderRepository.save(orderEntity1);
       }else {
           orderRepository.save(OrderEntity.builder()
                   .amount(1)
                   .build());
       }
    }
}


