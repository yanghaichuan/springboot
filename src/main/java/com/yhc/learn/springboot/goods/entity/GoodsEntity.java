package com.yhc.learn.springboot.goods.entity;

import java.util.Date;

public class GoodsEntity {
    private String id;

    private String userId;

    private String name;

    private Integer price;

    private Integer amount;

    private Integer withholdAmount;

    private Byte online;

    private Byte status;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getWithholdAmount() {
        return withholdAmount;
    }

    public void setWithholdAmount(Integer withholdAmount) {
        this.withholdAmount = withholdAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Byte getOnline() {
        return online;
    }

    public void setOnline(Byte online) {
        this.online = online;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
