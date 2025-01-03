package com.davv.NAAC.service;

import com.davv.NAAC.model.Program;
import com.davv.NAAC.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {


   @Autowired
    ProgramRepository programList;

    @Override
    public Program saveProgram(Program program) {
        programList.save(program);
        return program;
    }

    @Override
    public List<Program> findProgramBydeptID(String deptID) {
        List<Program> programs = programList.findAll();
        List<Program> result = new ArrayList<>();
        for (Program program : programs) {
            if (program.getDeptID().equals(deptID)) {
                result.add(program);
            }
        }

        return result;
    }


    @Override
    public Program updateProgram(String programCode, Program program) {
        return null;
    }

    @Override
    public void deleteProgram(String programCode) {

    }

    @Override
    public List<Program> savePrograms(List<Program> programs) {
        System.out.println("saved all"+programs);
        programList.saveAll(programs);
        return programs;
    }

    @Override
    public int get_a_count_by_deptId(String deptID) {
       int x=0;
        List<Program> programs = programList.findAll();

        for (Program program : programs) {
            if (program.getDeptID().equals(deptID)) {
             x++;
            }
        }

        return x;
    }

    /*
        @Override
        public Program findProgramByCode(String programCode) {
            for (Program program : programList) {
                if (program.getPrg_Code().equals(programCode)) {
                    return program;
                }
            }
            return null;
        }




        @Override
        public Program updateProgram(String programCode, Program program) {
            for (Program existingProgram : programList) {
                if (existingProgram.getPrg_Code().equals(programCode)) {
                    existingProgram.setSN(program.getSN());
                    existingProgram.setIIQA_PrgName(program.getIIQA_PrgName());
                    existingProgram.setDeptID(program.getDeptID());
                    existingProgram.setLevel(program.getLevel());
                    existingProgram.setYear_of_introduction(program.getYear_of_introduction());
                    return existingProgram;
                }
            }
            return null;
        }

        @Override
        public void deleteProgram(String programCode) {
            for (int i = 0; i < programList.size(); i++) {
                if (programList.get(i).getPrg_Code().equals(programCode)) {
                    programList.remove(i);
                    break;
                }
            }
        }
    */
    @Override
    public List<Program> findAllPrograms() {
        return programList.findAll();
    }
}
