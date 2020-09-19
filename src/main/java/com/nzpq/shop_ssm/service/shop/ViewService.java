package com.nzpq.shop_ssm.service.shop;

import com.nzpq.shop_ssm.pojo.Item;

import java.util.List;

public interface ViewService {

    List<Item> findZheKouItem();

    List<Item> findReMenItem();
}
