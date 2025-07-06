package org.example.LearnerManagementSystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String hello() {
        return "Welcome to the Learner Management System!";
    }
}
