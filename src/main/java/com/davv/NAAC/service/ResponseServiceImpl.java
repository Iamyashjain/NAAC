package com.davv.NAAC.service;

import com.davv.NAAC.model.Form;
import com.davv.NAAC.model.Response;
import com.davv.NAAC.repository.FormRepository;
import com.davv.NAAC.repository.ResponseRepository;
import com.davv.NAAC.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private FormRepository formRepository;

    @Override
    public Response saveResponse(Long formId, String departmentId, Map<String, String> formData) {


        // Create new Response object
        Response response = new Response();
        response.setForm_id(formId);
        response.setDepartment_id(departmentId);
        response.setSubmission_date_time(LocalDateTime.now().toString());
        response.setFieldResponses(formData);

        // Save and return the response
        return responseRepository.save(response);
    }

    @Override
    public List<Response> getAllResponses() {


        return responseRepository.findAll();
    }

    @Override
    public List<Response> getResponsesByFormId(Long formId) {
        // Fetch all responses
        List<Response> allResponses = responseRepository.findAll();

        // Create a list to hold the filtered responses
        List<Response> filteredResponses = new ArrayList<>();

        // Loop through all responses and add those that match the formId
        for (Response response : allResponses) {
            if (response.getForm_id().equals(formId)) {
                filteredResponses.add(response);
            }
        }

        return filteredResponses;
    }
    @Override
    public List<Response> getResponsesByDepartmentId(Long form_id,String departmentId) {
        List<Response> allResponses = responseRepository.findAll();

        // Create a list to hold the filtered responses
        List<Response> filteredResponses = new ArrayList<>();

        // Loop through all responses and add those that match the formId
        for (Response response : allResponses) {
            if (response.getDepartment_id().equals(departmentId) && response.getForm_id().equals(form_id)) {
                filteredResponses.add(response);
            }
        }

        return filteredResponses;
    }

    @Override
    public Response updateResponse(Long responseId, Long formId, String departmentId, Map<String, String> formData) {
        // Fetch the existing response by ID
        Response existingResponse = responseRepository.findById(responseId)
                .orElseThrow(() -> new IllegalArgumentException("Response not found with ID: " + responseId));

        // Update the response fields
        existingResponse.setForm_id(formId);
        existingResponse.setDepartment_id(departmentId);
        existingResponse.setSubmission_date_time(LocalDateTime.now().toString()); // Update the submission time
        existingResponse.setFieldResponses(formData);

        // Save the updated response
        return responseRepository.save(existingResponse);
    }

    @Override
    public int getcount_by_deptID(long formid,String deptID) {
        List<Response> allResponses = responseRepository.findAll();
        int x=0;

        // Create a list to hold the filtered responses
        List<Response> filteredResponses = new ArrayList<>();

        // Loop through all responses and add those that match the formId
        for (Response response : allResponses) {
            if (response.getDepartment_id().equals(deptID) && response.getForm_id().equals(formid)) {
                x++;
            }
        }

        return x;
    }

    @Override
    public int getcount_by_formID(Long formId) {
        List<Response> allResponses = responseRepository.findAll();
        int x=0;

        // Create a list to hold the filtered responses
        List<Response> filteredResponses = new ArrayList<>();

        // Loop through all responses and add those that match the formId
        for (Response response : allResponses) {
            if (response.getForm_id().equals(formId)) {
                x++;
            }
        }

        return x;

    }
}
