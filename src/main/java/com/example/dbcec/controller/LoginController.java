package com.example.dbcec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class LoginController {

    @GetMapping("/")
    public String home() {
        System.out.println( );
//        model.addAttribute("message", "Welcome to the home page!");
        return "home"; // 返回 home.html 视图
    }
}
