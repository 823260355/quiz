package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GoodsControllerTest {
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    private GoodsEntity goodsEntity;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void should_add_goods_when_name_no_exit() throws Exception {

        Goods goods = new Goods("可乐",3.0,"可口可乐公司","D://kele");
        String json = objectMapper.writeValueAsString(goods);
        mockMvc.perform(post("/goods/add").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<GoodsEntity> all = goodsRepository.findAll();
        assertEquals(1,all.size());
        assertEquals("可乐",all.get(0).getName());
    }

}