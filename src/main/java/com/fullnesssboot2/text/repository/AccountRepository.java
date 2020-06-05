package com.fullnesssboot2.text.repository;

import com.fullnesssboot2.text.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    Account findByUsername(String username);
}
