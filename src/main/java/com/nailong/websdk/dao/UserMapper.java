package com.nailong.websdk.dao;

import com.nailong.websdk.pojo.User;

public class UserMapper {
    public void saveUser(User user) {
        IO.println("saveUser: " + user.name);
    }

    public void updateUser(User user) {
        IO.println("updateUser: " + user.name);
    }

    public void delUser(User user) {
        IO.println("delUser: " + user.name);
    }

    public void queryUser(User user) {
        IO.println("queryUser: " + user.name);
    }
}
