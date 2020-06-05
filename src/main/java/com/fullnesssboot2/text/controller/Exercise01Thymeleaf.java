package com.fullnesssboot2.text.controller;

import com.fullnesssboot2.text.entity.Item;
import com.fullnesssboot2.text.repository.ItemRepository;
import com.fullnesssboot2.text.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("thym-exe-01")
@Controller
public class Exercise01Thymeleaf {
    @Autowired
    ItemRepository itemRepository;
    @GetMapping
    public String home(Model model){
        // Repositoryから取得する場合は↓
        // model.addAttribute("list",itemRepository.selectAll());
        List<Item> itemList = new ArrayList<Item>();
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("商品1");
        item1.setPrice(100);
        item1.setCategoryId(1);
        itemList.add(item1);
        Item item2 = new Item();
        item2.setId(2);
        item2.setName("商品2");
        item2.setPrice(200);
        item2.setCategoryId(1);
        itemList.add(item2);
        Item item3 = new Item();
        item3.setId(3);
        item3.setName("商品3");
        item3.setPrice(300);
        item3.setCategoryId(1);
        itemList.add(item3);
        model.addAttribute("list",itemList);

        // 条件分岐の確認
        model.addAttribute("isLogin",false);
        return "thym-exe-01";
    }
}
