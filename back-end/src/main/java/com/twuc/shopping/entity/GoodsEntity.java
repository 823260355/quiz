package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double price;
    private String unit;
    private String imgUrl;
}
