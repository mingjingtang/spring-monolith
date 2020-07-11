package com.ga.service;

import com.ga.entity.UserProfile;


public interface UserProfileService {
    public UserProfile createUserProfile(String username, UserProfile userProfile);
    public UserProfile getUserProfile(String username);
}
