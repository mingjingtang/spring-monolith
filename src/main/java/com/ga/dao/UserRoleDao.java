package com.ga.dao;

import com.ga.entity.UserRole;

public interface UserRoleDao {
    public UserRole createUserRole(UserRole userRole);
    public UserRole getUserRole(String rolename);
}
