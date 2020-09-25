package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
   private String name;
   private double price;
   private String unit;
   private String imaUrl;

}
