package com.ga.dao;

import com.ga.entity.User;
import com.ga.entity.UserRole;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public User signup(User user);
    public User login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);
    public User getUserByUsername(String username);
    public User addCourse(String username, int courseId);
}
