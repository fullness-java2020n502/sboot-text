package com.fullnesssboot2.text.repository;

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
}
