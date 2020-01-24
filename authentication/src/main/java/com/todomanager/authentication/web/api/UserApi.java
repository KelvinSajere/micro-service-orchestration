package com.todomanager.authentication.web.api;

import java.util.List;

import com.todomanager.authentication.business.service.RoleService;
import com.todomanager.authentication.business.service.UserService;
import com.todomanager.authentication.data.entity.Role;
import com.todomanager.authentication.data.entity.TodoUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserApi
 */
@RestController
public class UserApi {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/users")
    public List<TodoUser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping("/a")
    private String getStupid() {
        return "Craze";
    }
}