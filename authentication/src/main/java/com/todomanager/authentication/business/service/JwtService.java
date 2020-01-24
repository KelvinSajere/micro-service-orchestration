package com.todomanager.authentication.business.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.todomanager.authentication.data.entity.UserImp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    /**
     * - Validate UserName -
     * 
     * - Validate Date
     * 
     */

    @Value("${jwt.secret}")
    private String SECRET;
    @Value("${jwt.expiry}")
    private long EXPIRES_IN;
    @Value("${jwt.app_name}")
    private String APP_NAME;
    @Value("${jwt.header}")
    private String AUTH_HEADER;

    public String getUsernameFromToken(String token) {
        return this.getAllClaimsFromToken(token).getSubject();
    }

    private Date getExpirationDateFromToken(String token) {
        return this.getAllClaimsFromToken(token).getExpiration();
    }

    public String generateToken(UserImp user) {
        Date expiration = new Date();
        long msec = expiration.getTime() + EXPIRES_IN * 1000 * 60;
        expiration.setTime(msec);
        return Jwts.builder().setIssuer(APP_NAME).setSubject(user.getUsername()).setIssuedAt(new Date())
                .setHeaderParam("typ", "JWT").setExpiration(new Date(msec)).signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token, UserImp userDetails) {
        try {
            String username = getUsernameFromToken(token);
            Date expirationDate = getExpirationDateFromToken(token);
            return (expirationDate.after(new Date()) && username.equals(userDetails.getUsername()));
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Getting the token from Authentication header e.g Bearer your_token
     */
    public String getToken(HttpServletRequest request) {

        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    private String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }
}