package org.example.LearnerManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String hello() {
//        return "Welcome to the Learner Management System!";
        // This is a simple REST controller that handles GET requests to the root URL
        return "Welcome to the Learner Management System!";
    }
}
