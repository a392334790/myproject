package com.lwy.controller;

import com.lwy.domain.User;
import com.lwy.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable("id") Integer id) {
        return userClient.findById(id);
    }
}
