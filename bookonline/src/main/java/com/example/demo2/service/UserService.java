package com.example.demo2.service;


import com.example.demo2.entity.User;


import java.util.List;


public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 用户登陆功能
     *
     * @param account
     * @param password
     * @return user
     */
    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
