package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderControllerTest {

    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    OrderRepository orderRepository;
    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void should_add_order_is_succeed() throws Exception {
        GoodsEntity goodsEntity = GoodsEntity.builder()
                .name("可乐")
                .price(3.5)
                .unit("可口可乐公司")
                .imgUrl("D://kele")
                .build();
        goodsRepository.save(goodsEntity);
        Order order= Order.builder()
                .goodsId(goodsEntity.getId())
                .build();
        String json = objectMapper.writeValueAsString(order);

        mockMvc.perform(post("/orders")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        assertEquals(1, order.getAmount());
    }
}