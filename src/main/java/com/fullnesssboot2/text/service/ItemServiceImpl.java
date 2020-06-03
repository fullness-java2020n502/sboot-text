package com.fullnesssboot2.text.service;

import com.fullnesssboot2.text.entity.Item;
import com.fullnesssboot2.text.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional
    public void hurikomi(Item item1, Item item2) {
        itemRepository.create(item1);
        itemRepository.create(item2);
    }
}
