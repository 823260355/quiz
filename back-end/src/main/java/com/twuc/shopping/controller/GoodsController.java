package com.twuc.shopping.controller;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @PostMapping("/goods")
    public ResponseEntity createGood(@RequestBody Goods goods) {
        int num = goodsService.findAllByName(goods.getName());
        if (num != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        goodsService.addGoods(goods);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
