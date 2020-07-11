package com.ga.service;

import com.ga.entity.User;

import java.util.List;

public interface UserService {
    public List<User> listUser();
    public User signup(User user);
    public Long login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);
}
