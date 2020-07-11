package com.ga.controller;

import com.ga.entity.UserProfile;
import com.ga.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(username, userProfile);
    }

    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username){
        return userProfileService.getUserProfile(username);
    }
}
