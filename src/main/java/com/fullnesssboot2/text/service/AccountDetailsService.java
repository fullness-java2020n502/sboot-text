package com.fullnesssboot2.text.service;

import com.fullnesssboot2.text.entity.Account;
import com.fullnesssboot2.text.repository.AccountRepository;
import com.fullnesssboot2.text.security.AccountUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        System.out.println("account:"+account);
        if (account == null) throw new UsernameNotFoundException("user not found.");
        Collection<GrantedAuthority> authorities = getAuthority(account);
        return new AccountUserDetails(account,authorities);
    }
    private Collection<GrantedAuthority> getAuthority(Account account){
        if (account.getAccountRole().isAdmin()) return AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_GUEST");
        if (account.getAccountRole().isUser()) return AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_GUEST");
        return AuthorityUtils.createAuthorityList("ROLE_GUEST");
    }
}
