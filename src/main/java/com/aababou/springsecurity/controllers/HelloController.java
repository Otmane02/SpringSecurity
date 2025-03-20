package com.aababou.springsecurity.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
author otman
    */
@RestController
public class HelloController {

    @GetMapping("/hey")
    public String hey(HttpServletRequest request) {
        return "hey from spring security"+ " " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "about from spring security" + " " + request.getSession().getId();
    }
}
