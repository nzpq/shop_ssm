package com.nzpq.shop_ssm.service.shop;

import com.nzpq.shop_ssm.domain.CartInfo;
import com.nzpq.shop_ssm.pojo.*;

import java.util.List;

public interface ShopItemService {

    List<Item> findItems(Integer id, String condition);

    void addFavorite(Favorite favorite);

    List showFavorite(Integer uid);

    void removeFavorite(Favorite favorite);

    List<CartInfo> findCar(Integer id);

    void addCar(Integer itemId,Integer uid);

    void removeCar(Integer itemId,Integer uid);

    Item findItemDetail(Integer id);

    void addCars(Car car);

    void updateItemNum(Car car);

    void addItemOrder(List<Car> list, User user);

    List<ItemOrder> findAllMyOrder(Integer uid,Integer status);

    void deleteOrder(Integer id);


    void payOrder(Integer id);

    void getOrder(Integer id);

    void addComment(Comment comment);

    void findComment(Integer uid,Integer itemId);
}
