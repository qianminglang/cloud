package com.clear.controller;

import com.clear.dto.input.User;
import com.clear.service.HelloFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName UserController
 *
 * @author qml
 * Date 2020/12/24 14:25
 * Version 1.0
 **/

@RestController
public class HelloFacadeImpl8308 implements HelloFacade {
    @Value("${server.port}")
    private int port;

    @Override
    public String hello(String name) {
        System.out.println("进入"+port);
//        int i=1/0;
        System.out.println("出来"+port);
        return "hello " + name + ":" + port;
    }

    @DeleteMapping("/user/{id}")
    @Override
    public void deleteUserById(@PathVariable Long id) {
        System.out.println(id);
    }

    @GetMapping("/user")
    @Override
    public User getUserByName(@RequestParam String name) {
        User user = new User();
        user.setUsername(name);
        return user;
    }

    @PostMapping("/user")
    @Override
    public User addUser(@RequestBody User user) {
        return user;
    }

    @PutMapping("/user")
    @Override
    public void updateUserById(@RequestHeader String name, @RequestHeader Long id) {
        System.out.println("name:" + name + ";id:" + id);
    }
}