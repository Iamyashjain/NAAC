package com.davv.NAAC.service;

import com.davv.NAAC.model.Program;
import java.util.List;

public interface ProgramService {

    Program saveProgram(Program program);

    List<Program> findProgramBydeptID(String deptID);
//no need of update
    Program updateProgram(String programCode, Program program);

    void deleteProgram(String programCode);

    List<Program> findAllPrograms();

    List<Program> savePrograms(List<Program> programs);

    int get_a_count_by_deptId(String deptID);
}
