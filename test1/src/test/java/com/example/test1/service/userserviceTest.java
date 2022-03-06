package com.example.test1.service;

import com.example.test1.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class userserviceTest {
    @Test
    void login() {
        userservice userService = new userservice();
        user user = userService.login("zhangsan", "123");
        if (user != null) {
            System.out.println(user.toString());
        }
    }

}