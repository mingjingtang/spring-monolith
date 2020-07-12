package com.ga.service;

import com.ga.dao.UserRoleDao;
import com.ga.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public UserRole createUserRole(UserRole newRole) {
        return userRoleDao.createUserRole(newRole);
    }

    @Override
    public UserRole getUserRole(String rolename) {
        return userRoleDao.getUserRole(rolename);
    }
}
