package com.fullnesssboot2.text.repository;

import com.fullnesssboot2.text.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRepository {
    List<Item> selectAll();
    Item selectById(Integer id);
    void create(Item item);
    Boolean updateById(Item item);
}
