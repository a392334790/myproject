package com.lwy.feign;

import com.lwy.domain.User;
import com.lwy.feign.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-provider",fallback = UserClientFallBack.class)
public interface UserClient {
    @RequestMapping("/user/find/{id}")
    User findById(@PathVariable("id") Integer id);
}
