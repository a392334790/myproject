package com.lwy.controller;

import com.lwy.domain.User;
import com.lwy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public User findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        user.setUsername("provider--02"+user.getUsername());
        return user;
    }


}
