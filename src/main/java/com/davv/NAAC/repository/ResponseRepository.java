package com.davv.NAAC.repository;

import com.davv.NAAC.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

    // Additional query methods if needed
}
