package com.foamtec;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wutthinan on 1/1/2017 AD.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/role", method = RequestMethod.GET, headers = "Content-Type=Application/json")
    public String api() {
        return "api";
    }
}
