package com.fullnesssboot2.text.repository;

import com.fullnesssboot2.text.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;
    @Test
    void testSelectAll(){
        itemRepository.selectAll().forEach(item -> System.out.println(item));
    }
    @Test
    void testSelectById(){
        System.out.println(itemRepository.selectById(2));
    }
    @Test
    void testCreate(){
        Item item = new Item();
        item.setName("ボールペン");
        item.setPrice(120);
        item.setCategoryId(1);
        itemRepository.create(item);
    }
    @Test
    void testUpdateById(){
        Item item = new Item();
        item.setId(1);
        item.setName("ボールペン2");
        item.setPrice(130);
        item.setCategoryId(2);
        itemRepository.updateById(item);
    }

}
