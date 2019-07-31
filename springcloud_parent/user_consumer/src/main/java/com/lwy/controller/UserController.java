package com.lwy.controller;

import com.lwy.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@DefaultProperties(defaultFallback = "defaultFailBack")
@RestController
@RequestMapping("/consumer")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Integer id) {
       /* String url="http://localhost:8081/user/find/"+id;
        return restTemplate.getForObject(url, User.class);*/
       /* List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        ServiceInstance serviceInstance = instances.get(0);*/
       if (id==1){
           throw new RuntimeException();
       }

        String url = "http://user-provider/user/find/" + id;
        return restTemplate.getForObject(url, User.class);
    }

    public User fallBack(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("failed fallback.....");
        return  user;
    }

    public User defaultFailBack(){
        User user = new User();
        user.setUsername("Default-服务降级,默认处理！");
        return  user;
    }
}
