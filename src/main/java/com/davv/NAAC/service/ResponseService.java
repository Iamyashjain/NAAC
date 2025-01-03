package com.davv.NAAC.service;

import com.davv.NAAC.model.Response;

import java.util.List;
import java.util.Map;

public interface ResponseService {
    
    // Method to save response
    Response saveResponse(Long formId, String departmentId, Map<String, String> formData);

    // Method to get all responses
    List<Response> getAllResponses();

    // Method to get response by form ID
    List<Response> getResponsesByFormId(Long formId);

    // Method to get response by department ID
    List<Response> getResponsesByDepartmentId(Long formID,String departmentId);
    Response updateResponse(Long responseId, Long formId, String departmentId, Map<String, String> formData);
    int getcount_by_deptID(long formid,String deptID);
    int getcount_by_formID(Long formId);
}
