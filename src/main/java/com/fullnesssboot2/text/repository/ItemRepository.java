package com.fullnesssboot2.text.repository;

import com.fullnesssboot2.text.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemRepository {
    List<Item> selectAll();
}
