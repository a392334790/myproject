package com.lwy.feign.fallback;

import com.lwy.domain.User;
import com.lwy.feign.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("Feign Fallback.....");
        return user;
    }
}
