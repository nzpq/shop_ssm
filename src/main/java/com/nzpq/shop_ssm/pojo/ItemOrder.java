package com.nzpq.shop_ssm.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemOrder {
    private Integer id;
    private Integer item_id;//商品id 这个属性没用
    private Integer user_id;//用户id
    private String code;//订单号
    private Date addTime;//订单时间
    private String total;//金额
    private Integer isDelete;//0未删除：1，已删除
    private Integer status;//状态：0.未发货，1.已取消， 2已发货，3已收货，4待付款,5已评价


    private User user;//该订单对应的用户信息
    private List<OrderDetail> details;

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemOrder{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", user_id=" + user_id +
                ", code='" + code + '\'' +
                ", addTime=" + addTime +
                ", total='" + total + '\'' +
                ", isDelete=" + isDelete +
                ", status=" + status +
                ", user=" + user +
                ", details=" + details +
                '}';
    }
}
