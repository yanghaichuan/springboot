package com.yhc.learn.springboot.goods.controller;

import com.yhc.learn.springboot.common.generate.UuidUtil;
import com.yhc.learn.springboot.common.redis.RedisUtil;
import com.yhc.learn.springboot.goods.entity.GoodsEntity;
import com.yhc.learn.springboot.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods/action")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/get")
    public GoodsEntity get(@RequestParam String id){
        GoodsEntity goods = new GoodsEntity();
        goods.setId("124455657789899");
        goods.setName("美女一枚");
        goods.setAmount(10);
        goods.setWithholdAmount(5);
        goods.setPrice(111);
        return goods;
    }

    @RequestMapping("/save")
    public Map<String,Object> save(@RequestBody GoodsEntity goods){
        Map<String,Object> result = new HashMap<>();
        goods.setId(UuidUtil.getUuid());
        goods.setName("美女一枚");
        goods.setAmount(10);
        goods.setWithholdAmount(5);
        goods.setPrice(2222);
        goods.setUserId("0c612f80-380d-4fe9-960a-64c843aee938");
        goods.setOnline(new Byte("1"));
        goods.setStatus(new Byte("2"));
        goods.setCreateTime(new Date());
        int s = goodsService.insert(goods);
        result.put("code",0);
        result.put("state",1);
        return result;
    }
}
