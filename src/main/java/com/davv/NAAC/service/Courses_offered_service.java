package com.davv.NAAC.service;

import com.davv.NAAC.model.Courses_offered;
import java.util.List;

public interface Courses_offered_service {
    // Save a new course
    Courses_offered saveCourse(Courses_offered course);

    // Find course by ID
    Courses_offered findCourseById(String courseId);

    // Update existing course
    Courses_offered updateCourse(String courseId, Courses_offered course);

    // Delete course by ID
    void deleteCourseById(String courseId);

    // List all courses
    List<Courses_offered> findAllCourses();
}
