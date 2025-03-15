package com.davv.NAAC.controller;

import com.davv.NAAC.model.Program;
import com.davv.NAAC.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping("/multiple")
    public List<Program> createPrograms(@RequestBody List<Program> programs) {
        return programService.savePrograms(programs);
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.saveProgram(program);
    }

    @GetMapping("/{deptID}")
    public List<Program> getProgrambyID(@PathVariable String deptID) {
        return programService.findProgramBydeptID(deptID);
    }

    @GetMapping("/count/{deptID}")
    public int getcount(@PathVariable String deptID) {
        System.out.println(deptID);
        return programService.get_a_count_by_deptId(deptID);
    }

    @PutMapping("/{programCode}")
    public Program updateProgram(@PathVariable String programCode, @RequestBody Program program) {
        return programService.updateProgram(programCode, program);
    }

    @DeleteMapping("/{programCode}")
    public void deleteProgram(@PathVariable String programCode) {
        programService.deleteProgram(programCode);
    }

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.findAllPrograms();
    }
}
