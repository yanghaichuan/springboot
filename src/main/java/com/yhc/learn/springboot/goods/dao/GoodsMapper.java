package com.yhc.learn.springboot.goods.dao;

import com.yhc.learn.springboot.goods.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsEntity record);

    int insertSelective(GoodsEntity record);

    GoodsEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsEntity record);

    int updateByPrimaryKey(GoodsEntity record);

    List<GoodsEntity> list(Map<String,Object> scs);

    int buckleWithholdAmount(@Param(value = "goodsId") String goodsId, @Param(value = "amount") int amount);

    int buckleAmount(@Param(value = "goodsId") String goodsId, @Param(value = "amount") int amount);
}
