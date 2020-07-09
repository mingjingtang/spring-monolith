package com.ga.controller;

import com.ga.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello World!!";
//    }
    private List<User> users;

    @PostConstruct
    public void initializaUsers(){
        users = new ArrayList<>();

        users.add(new User("batman", "bat"));
        users.add(new User("spiderman", "spider"));
    }

    @GetMapping("/users")
    public List<User> getUsers(){
       return users;
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        User foundUser = users.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
        return foundUser;
    }
}
