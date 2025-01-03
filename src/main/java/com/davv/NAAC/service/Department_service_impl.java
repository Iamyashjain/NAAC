package com.davv.NAAC.service;

import com.davv.NAAC.model.Department;
import com.davv.NAAC.repository.Department_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Department_service_impl implements Department_service {

    @Autowired
    private Department_repo departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(String departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        return department.orElse(null); // Return null if not found
    }

    @Override
    public Department updateDepartment(String departmentId, Department department) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentId);
        if (existingDepartment.isPresent()) {
            Department updatedDepartment = existingDepartment.get();
            updatedDepartment.setDepartment_name(department.getDepartment_name());
            return departmentRepository.save(updatedDepartment);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteDepartmentById(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> saveDepartment(List<Department> Departments) {
       return departmentRepository.saveAll(Departments);
    }
}
