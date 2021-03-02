package com.clear.service;

import com.clear.dto.input.User;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName UserService
 *
 * @author qml
 * Date 2020/12/24 14:28
 * Version 1.0
 **/
public interface HelloFacade {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
    @DeleteMapping("/user/{id}")
    void deleteUserById(@PathVariable("id") Long id);
    @GetMapping("/user")
    User getUserByName(@RequestParam("name") String name);
    @PostMapping("/user")
    User addUser(@RequestBody User user);
    @PutMapping("/user")
    void updateUserById(@RequestHeader("name") String name, @RequestHeader("id") Long id);

    @RequestMapping("/foo")
    String foo(@RequestParam("foo")String foo);
}