package com.nzpq.shop_ssm.domain;

import com.nzpq.shop_ssm.pojo.ItemCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Category {
    private ItemCategory parent;
    private List<ItemCategory> childrens;

    public ItemCategory getParent() {
        return parent;
    }

    public void setParent(ItemCategory parent) {
        this.parent = parent;
    }

    public List<ItemCategory> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<ItemCategory> childrens) {
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parent=" + parent +
                ", childrens=" + childrens +
                '}';
    }
}
