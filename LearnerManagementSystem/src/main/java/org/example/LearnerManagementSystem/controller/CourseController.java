package org.example.LearnerManagementSystem.controller;

import org.example.LearnerManagementSystem.entity.Course;
import org.example.LearnerManagementSystem.repository.CourseRepository;
import org.example.LearnerManagementSystem.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class CourseController {

    @Autowired
    private CourseManagementService courseManagementService;

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        // Logic to save the course to the database would go here
        // For now, we will just return the course object
        return courseManagementService.addCourse(course);
    }


}
