package com.fullnesssboot2.text.repository;

import com.fullnesssboot2.text.entity.Item;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.dbunit.database.IDatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DatabaseSetup(value = "/dbunit/init/")
    @ExpectedDatabase(value = "/dbunit/init/", table = "item", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void testSelectAll(){
        itemRepository.selectAll().forEach(item -> System.out.println(item));
    }

    @Test
    @DatabaseSetup(value = "/dbunit/init/")
    @ExpectedDatabase(value = "/dbunit/init/", table = "item", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void testSelectById(){
        Item item = itemRepository.selectById(1);
        Assertions.assertEquals(1,item.getId());
        Assertions.assertEquals("商品1",item.getName());
        Assertions.assertEquals(1000,item.getPrice());
    }

    @Test
    @DatabaseSetup(value = "/dbunit/init/")
    @ExpectedDatabase(value = "/dbunit/add/", table = "item", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void testCreate(){
        jdbcTemplate.execute("select setval ('item_seq', 4, false)"); // シーケンスを合わせないといけない
        Item item = new Item();
        item.setId(4);
        item.setName("商品4");
        item.setPrice(4000);
        item.setCategoryId(2);
        itemRepository.create(item);
    }

    @Test
    @DatabaseSetup(value = "/dbunit/init/")
    @ExpectedDatabase(value = "/dbunit/update/", table = "item", assertionMode = DatabaseAssertionMode.NON_STRICT)
    void testUpdateById(){
        Item item = new Item();
        item.setId(1);
        item.setName("ボールペン");
        item.setPrice(1100);
        item.setCategoryId(2);
        itemRepository.updateById(item);
    }

}
