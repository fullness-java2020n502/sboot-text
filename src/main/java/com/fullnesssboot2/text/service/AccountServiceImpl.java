package com.fullnesssboot2.text.service;

import com.fullnesssboot2.text.entity.Account;
import com.fullnesssboot2.text.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void create(Account account) {
        String password = account.getPassword();
        account.setPassword(passwordEncoder.encode(password));
        //accountRepository.create(account);
    }
}
