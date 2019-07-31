package com.lwy.service.impl;

import com.lwy.dao.UserDao;
import com.lwy.domain.User;
import com.lwy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}
