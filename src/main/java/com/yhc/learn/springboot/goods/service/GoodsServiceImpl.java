package com.yhc.learn.springboot.goods.service;

import com.yhc.learn.springboot.goods.dao.GoodsMapper;
import com.yhc.learn.springboot.goods.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public int insert(GoodsEntity goods) {
        return goodsMapper.insert(goods);
    }
}
