package com.davv.NAAC.service;

import com.davv.NAAC.model.Courses_offered;
import com.davv.NAAC.repository.Courses_offered_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Courses_offered_service_impl implements Courses_offered_service {

    @Autowired
    private Courses_offered_repo coursesOfferedRepository;

    @Override
    public Courses_offered saveCourse(Courses_offered course) {
        return coursesOfferedRepository.save(course);
    }

    @Override
    public Courses_offered findCourseById(String courseId) {
        Optional<Courses_offered> course = coursesOfferedRepository.findById(courseId);
        return course.orElse(null); // Return null if not found
    }

    @Override
    public Courses_offered updateCourse(String courseId, Courses_offered course) {
        Optional<Courses_offered> existingCourse = coursesOfferedRepository.findById(courseId);
        if (existingCourse.isPresent()) {
            Courses_offered updatedCourse = existingCourse.get();
            updatedCourse.setDepartment_id(course.getDepartment_id()); // Set department_id
            updatedCourse.setTotal_seats(course.getTotal_seats());
            updatedCourse.setSeats_admitted(course.getSeats_admitted());
            updatedCourse.setCourse_type(course.getCourse_type());
            updatedCourse.setCourse_name(course.getCourse_name());
            return coursesOfferedRepository.save(updatedCourse);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteCourseById(String courseId) {
        coursesOfferedRepository.deleteById(courseId);
    }

    @Override
    public List<Courses_offered> findAllCourses() {
        return coursesOfferedRepository.findAll();
    }
}
