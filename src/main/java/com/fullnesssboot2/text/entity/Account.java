package com.fullnesssboot2.text.entity;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private String userName;
    private String password;
    private String displayName;
    private Boolean enabled;
    private Integer roleId;
    private AccountRole accountRole;
}
