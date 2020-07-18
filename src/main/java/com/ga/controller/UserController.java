package com.ga.controller;

import com.ga.entity.JwtResponse;
import com.ga.entity.User;
import com.ga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.listUser();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        return ResponseEntity.ok(new JwtResponse(userService.signup(user)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Long userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }

    @PutMapping("/{username}/course/{courseId}")
    public User addCourse(@PathVariable String username, @PathVariable int courseId){
        return userService.addCourse(username, courseId);
    }
}
