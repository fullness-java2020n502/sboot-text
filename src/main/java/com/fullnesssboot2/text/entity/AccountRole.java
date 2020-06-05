package com.fullnesssboot2.text.entity;

import lombok.Data;

@Data
public class AccountRole {
    private Integer roleId;
    private String roleName;
    public Boolean isAdmin(){
        if (roleId == 1) return true;
        return false;
    }
    public Boolean isUser(){
        if (roleId == 2) return true;
        return false;
    }
    public Boolean isGuest(){
        if (roleId == 3) return true;
        return false;
    }
}
