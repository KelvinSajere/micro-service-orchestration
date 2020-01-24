package com.todomanager.authentication.web.api;

import com.todomanager.authentication.business.service.AuthenticationService;
import com.todomanager.authentication.data.entity.TodoUser;
import com.todomanager.authentication.data.entity.TokenState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Authenticate
 */
@RestController
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public TokenState login(@RequestBody TodoUser user) {
        return authService.authenticateUser(user);

    }

}