package com.ga.service;

import com.ga.entity.UserRole;

public interface UserRoleService {
    public UserRole createUserRole(UserRole newRole);
    public UserRole getUserRole(String rolename);
}
