package com.twuc.shopping.dto;

import com.twuc.shopping.entity.GoodsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods {
   private String name;
   private double price;
   private String unit;
   private String imgUrl;

   public static Goods from(GoodsEntity goodsEntity) {
      return Goods.builder()
              .name(goodsEntity.getName())
              .price(goodsEntity.getPrice())
              .unit(goodsEntity.getUnit())
              .imgUrl(goodsEntity.getImgUrl())
              .build();
   }
}
