package com.ga.controller;

import com.ga.entity.User;
import com.ga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.listUser();
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    public Long login(@RequestBody User user){
        return userService.login(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Long userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
