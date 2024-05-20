package com.yzq.springbootjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yzq.springbootjwt.entity.User;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())// Embed the user ID into the token.
                .sign(Algorithm.HMAC256(user.getPassword()));// Use the password as the key for the token.
        return token;
    }
}
