package com.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello from the auth-service!";
    }

}
