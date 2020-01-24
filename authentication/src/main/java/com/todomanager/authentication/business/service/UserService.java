package com.todomanager.authentication.business.service;

import java.util.List;
import java.util.Optional;

import com.todomanager.authentication.business.repository.UserRepository;
import com.todomanager.authentication.data.entity.TodoUser;
import com.todomanager.authentication.data.entity.UserImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public List<TodoUser> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserImp loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TodoUser> user = userRepo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return user.map(UserImp::new).get();
    }
}