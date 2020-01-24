package com.todomanager.authentication.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * TokenState
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class TokenState {
    private final String jwt_token;
    private final long expires_in;

}