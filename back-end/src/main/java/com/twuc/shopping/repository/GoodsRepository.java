package com.twuc.shopping.repository;

import com.twuc.shopping.entity.GoodsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<GoodsEntity, Integer> {
    List<GoodsEntity> findAll();
    List<GoodsEntity> findAllByName(String name);
}
