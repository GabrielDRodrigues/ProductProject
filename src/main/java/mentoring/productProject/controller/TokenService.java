package mentoring.productProject.controller;

import io.jsonwebtoken.Jwts;
import mentoring.productProject.resource.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    public String generateToken(Authentication authentication){
        User loggin = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date (today.getTime() + expiration);

        return Jwts.builder()
                .setIssuer("API Product Project")
                .setSubject(loggin.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .compact();
    }

}
