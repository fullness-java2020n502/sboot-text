package com.fullnesssboot2.text.service;

import com.fullnesssboot2.text.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemServiceTest {
    @Autowired
    ItemService itemServiceImpl;
    @Test
    void testHurikomi(){
        Item item1 = new Item();
        item1.setId(100);
        item1.setName("ボールペン");
        item1.setPrice(3000);
        item1.setCategoryId(1);
        // 二つ目のItem同じIDにする（トランザクションでロールバックするため）
        Item item2 = new Item();
        item2.setId(100);
        item2.setId(10000000);
        item2.setName("ボールペン2");
        item2.setPrice(40000);
        item2.setCategoryId(1);
        itemServiceImpl.hurikomi(item1,item2);
    }
}
