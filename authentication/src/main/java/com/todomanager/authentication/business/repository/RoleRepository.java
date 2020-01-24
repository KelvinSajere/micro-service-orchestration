package com.todomanager.authentication.business.repository;

import java.util.List;

import com.todomanager.authentication.data.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

}