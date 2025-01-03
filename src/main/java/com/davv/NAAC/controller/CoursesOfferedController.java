package com.davv.NAAC.controller;

import com.davv.NAAC.model.Courses_offered;
import com.davv.NAAC.service.Courses_offered_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class CoursesOfferedController {

    @Autowired
    private Courses_offered_service coursesOfferedService;

    // Create a new course
    @PostMapping
    public Courses_offered createCourse(@RequestBody Courses_offered course) {
        System.out.println(course);

        return coursesOfferedService.saveCourse(course);
    }

    // Get a course by ID
    @GetMapping("/{courseId}")
    public Courses_offered getCourse(@PathVariable String courseId) {
        return coursesOfferedService.findCourseById(courseId);
    }

    // Update an existing course by ID
    @PutMapping("/{courseId}")
    public Courses_offered updateCourse(@PathVariable String courseId, @RequestBody Courses_offered course) {
        return coursesOfferedService.updateCourse(courseId, course);
    }

    // Delete a course by ID
    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        coursesOfferedService.deleteCourseById(courseId);
    }

    // Get all courses
    @GetMapping
    public List<Courses_offered> getAllCourses() {
        return coursesOfferedService.findAllCourses();
    }
}
