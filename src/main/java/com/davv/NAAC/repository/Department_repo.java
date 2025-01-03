package com.davv.NAAC.repository;

import com.davv.NAAC.model.Department;
import com.davv.NAAC.model.login_data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Department_repo extends JpaRepository<Department,String> {
}
