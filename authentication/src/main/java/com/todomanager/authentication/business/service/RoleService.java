package com.todomanager.authentication.business.service;

import java.util.List;

import com.todomanager.authentication.business.repository.RoleRepository;
import com.todomanager.authentication.data.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleService
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

}