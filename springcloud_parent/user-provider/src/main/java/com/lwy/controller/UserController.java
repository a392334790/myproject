package com.lwy.controller;

import com.lwy.domain.User;
import com.lwy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public User findById(@PathVariable("id") Integer id) throws InterruptedException {
        User user = userService.findById(id);
        user.setUsername("provider--01"+user.getUsername());
        if (Math.random()>0.5)
        Thread.sleep(3000);
        return user;
    }


}
