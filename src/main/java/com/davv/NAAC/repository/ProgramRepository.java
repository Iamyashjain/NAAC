package com.davv.NAAC.repository;

import com.davv.NAAC.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program, Long> {


    // Program Code is the ID, so no need for additional methods yet
}
