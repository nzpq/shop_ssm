package com.nzpq.shop_ssm.pojo;

import java.math.BigDecimal;

public class Car {
    private Integer id;
    private Integer item_id;
    private Integer user_id;
    private Integer num; //数量
    private BigDecimal price; //价格
    private BigDecimal total; //总钱数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", user_id=" + user_id +
                ", num=" + num +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
