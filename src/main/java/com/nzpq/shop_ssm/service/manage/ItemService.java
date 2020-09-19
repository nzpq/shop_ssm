package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    List<Item> findAllItem(Integer page, Integer size, Item item);

    void addItem(Item item, MultipartFile[] files);

    void deleteItem(Integer id);
}
