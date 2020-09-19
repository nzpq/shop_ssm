package com.nzpq.shop_ssm.pojo;

import org.springframework.stereotype.Component;

/**
 *
 * 商品详情
 */
@Component
public class OrderDetail {
    //主键
    private Integer id;
    //商品id
    private Integer item_id;
    private Item item;
    //订单id
    private Integer order_id;
    //0.未退货 1已退货
    private Integer status;
    //数量
    private Integer num;
    //小计
    private String total;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", item=" + item +
                ", order_id=" + order_id +
                ", status=" + status +
                ", num=" + num +
                ", total='" + total + '\'' +
                '}';
    }
}
