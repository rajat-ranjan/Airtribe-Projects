package org.example.LearnerManagementSystem.service;

import org.example.LearnerManagementSystem.entity.Course;
import org.example.LearnerManagementSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseManagementService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
