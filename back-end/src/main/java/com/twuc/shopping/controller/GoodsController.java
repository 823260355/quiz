package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @PostMapping("/goods/add")
    public void register(@RequestBody Goods goods){
        goodsService.addGoods(goods);
    }
}
