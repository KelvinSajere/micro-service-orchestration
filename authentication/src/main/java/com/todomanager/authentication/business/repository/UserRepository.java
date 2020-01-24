package com.todomanager.authentication.business.repository;

import java.util.List;
import java.util.Optional;

import com.todomanager.authentication.data.entity.TodoUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends CrudRepository<TodoUser, Long> {

    List<TodoUser> findAll();

    Optional<TodoUser> findByUsername(String username);

    List<TodoUser> findByUsernameAndPassword(String username, String password);
}