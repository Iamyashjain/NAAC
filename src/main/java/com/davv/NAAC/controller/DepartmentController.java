package com.davv.NAAC.controller;

import com.davv.NAAC.model.Department;
import com.davv.NAAC.model.Program;
import com.davv.NAAC.service.Department_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private Department_service departmentService;

    // Create a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/multiple")
    public List<Department> createPrograms(@RequestBody List<Department> Departments) {
        return departmentService.saveDepartment(Departments);
    }
    // Get a department by ID
    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable String departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }

    // Update an existing department by ID
    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    // Delete a department by ID
    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }
}
