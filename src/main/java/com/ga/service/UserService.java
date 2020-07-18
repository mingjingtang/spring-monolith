package com.ga.service;

import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> listUser();
    public String signup(User user);
    public String login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);
    public User addCourse(String username, int courseId);
}
