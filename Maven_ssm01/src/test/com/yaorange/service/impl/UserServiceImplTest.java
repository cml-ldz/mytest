package com.yaorange.service.impl;

import com.yaorange.entity.User;
import com.yaorange.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void findAll() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}