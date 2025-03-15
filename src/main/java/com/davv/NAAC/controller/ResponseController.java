package com.davv.NAAC.controller;

import com.davv.NAAC.model.Response;
import com.davv.NAAC.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;


    // Endpoint to submit a response using path variables
    @PostMapping("/submit")
    public Response submitResponse(@RequestBody Response response) {

        return responseService.saveResponse(response.getForm_id(), response.getDepartment_id(), response.getFieldResponses());
    }

    // Endpoint to get all responses
    @GetMapping("/all")
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    // Endpoint to get responses by form ID
    @GetMapping("/form/{formId}")
    public List<Response> getResponsesByFormId(@PathVariable Long formId) {
        return responseService.getResponsesByFormId(formId);
    }

    // Endpoint to get responses by department ID
    @GetMapping("/department/{formId}/{departmentId}")
    public List<Response> getResponsesByDepartmentId(@PathVariable String departmentId, @PathVariable Long formId) {
        return responseService.getResponsesByDepartmentId(formId,departmentId);
    }

    // Update response API endpoint
    @PutMapping("/update/{responseId}")
    public Response updateResponse(
            @PathVariable Long responseId,
            @RequestBody Response updatedResponse) {
        return responseService.updateResponse(
                responseId,
                updatedResponse.getForm_id(),
                updatedResponse.getDepartment_id(),
                updatedResponse.getFieldResponses()
        );
    }

    @GetMapping("/department/count_by_deptID/{formid}/{departmentId}")
    public int get_count_of_ResponsesByDepartmentId(@PathVariable String departmentId,@PathVariable Long formid) {
        return responseService.getcount_by_deptID(formid,departmentId);
    }

    @GetMapping("/department/count_by_form_id/{form_id}")
    public int getResponsesByDepartmentId(@PathVariable Long form_id) {
        return responseService.getcount_by_formID(form_id);
    }
}

