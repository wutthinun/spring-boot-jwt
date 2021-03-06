package com.foamtec;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.*;

/**
 * Created by wutthinan on 1/1/2017 AD.
 */
@RestController
public class LoginController {

    private final Map<String, List<String>> userDb = new HashMap<>();

    public LoginController() {
        userDb.put("tom", Arrays.asList("user"));
        userDb.put("sally", Arrays.asList("user", "admin"));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Content-Type=Application/json")
    public LoginResponse login(@RequestBody final UserLogin login)
            throws ServletException
    {
        if (login.name == null || !userDb.containsKey(login.name)) {
            throw new ServletException("Invalid login");
        }
        return new LoginResponse(Jwts.builder()
                .setSubject(login.name)
                .claim("roles", userDb.get(login.name))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact());
    }

    @SuppressWarnings("unused")
    private static class UserLogin {
        public String name;
        public String password;
    }

    @SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
