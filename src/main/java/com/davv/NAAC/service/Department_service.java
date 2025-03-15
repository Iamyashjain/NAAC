package com.davv.NAAC.service;

import com.davv.NAAC.model.Department;
import com.davv.NAAC.model.Program;

import java.util.List;

public interface Department_service {
    // Save a new department
    Department saveDepartment(Department department);

    // Find department by ID
    Department findDepartmentById(String departmentId);

    // Update existing department
    Department updateDepartment(String departmentId, Department department);

    // Delete department by ID
    void deleteDepartmentById(String departmentId);

    // List all departments
    List<Department> findAllDepartments();

    List<Department> saveDepartment(List<Department> Departments);
}
