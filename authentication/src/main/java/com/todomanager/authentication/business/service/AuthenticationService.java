package com.todomanager.authentication.business.service;

import com.todomanager.authentication.data.entity.TodoUser;
import com.todomanager.authentication.data.entity.TokenState;
import com.todomanager.authentication.data.entity.UserImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Authenticate
 */
@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authManager;

    @Value("${jwt.expiry}")
    private long expiresIn;
    @Autowired
    private JwtService tokenService;

    public TokenState authenticateUser(TodoUser user) {
        Authentication authenticationResult = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String jwtToken = tokenService.generateToken(((UserImp) authenticationResult.getPrincipal()));

        return new TokenState(jwtToken, expiresIn);
    }

}