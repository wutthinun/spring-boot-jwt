package com.foamtec;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wutthinan on 1/1/2017 AD.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/role", method = RequestMethod.GET, headers = "Content-Type=Application/json")
    public String api(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        System.out.println("Claims ==> "+claims);
        return "api";
    }
}
