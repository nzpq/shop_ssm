package com.nzpq.shop_ssm.domain;

public class QueryVO {
    private Integer id;
    private Object condition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "QueryVO{" +
                "id=" + id +
                ", condition=" + condition +
                '}';
    }
}
