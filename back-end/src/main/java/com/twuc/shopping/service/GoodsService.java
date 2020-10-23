package com.twuc.shopping.service;

import com.twuc.shopping.dto.Goods;
import com.twuc.shopping.entity.GoodsEntity;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Resource
    GoodsRepository goodsRepository;
    public GoodsEntity goodsToGoodsEntity(Goods goods) {
        return GoodsEntity.builder()
                .name(goods.getName())
                .price(goods.getPrice())
                .unit(goods.getUnit())
                .imgUrl(goods.getImgUrl())
                .build();
    }

    public List<Goods> goodsEntityToGoods(List<GoodsEntity> goodsEntity) {
        return goodsRepository.findAll().stream()
                .map(Goods::from)
                .collect(Collectors.toList());
    }

    public void addGoods(Goods goods){
        GoodsEntity goodsEntity = goodsToGoodsEntity(goods);
        goodsRepository.save(goodsEntity);
    }
    public int findAllByName(String name){
        List<GoodsEntity> allGoodOfNameSame = goodsRepository.findAllByName(name);
        return allGoodOfNameSame.size();
    }

    public List<Goods> getGoods() {
        List<GoodsEntity> goodsEntities = goodsRepository.findAll();
        return goodsEntityToGoods(goodsEntities);
    }
}
