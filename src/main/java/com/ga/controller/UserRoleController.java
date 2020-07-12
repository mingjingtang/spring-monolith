package com.ga.controller;

import com.ga.entity.UserRole;
import com.ga.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping
    public UserRole createUserRole(@RequestBody UserRole newRole){
        return userRoleService.createUserRole(newRole);
    }

    @GetMapping("/{rolename}")
    public UserRole getUserRole(@PathVariable String rolename){
        return userRoleService.getUserRole(rolename);
    }
}
