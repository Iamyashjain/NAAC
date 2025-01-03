package com.davv.NAAC.controller;

import com.davv.NAAC.model.Form;
import com.davv.NAAC.model.Program;
import com.davv.NAAC.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    // Get all forms
    @GetMapping
    public List<Form> getAllForms() {
        List<Form> forms = formService.getAllForms();
        return forms;
    }

    // Get form by ID
    @GetMapping("/{id}")
    public ResponseEntity<Form> getFormById(@PathVariable long id) {
        Form form = formService.getFormById(id);
        if (form != null) {
            return new ResponseEntity<>(form, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create or update form
    @PostMapping
    public ResponseEntity<Form> createOrUpdateForm(@RequestBody Form form) {
        Form savedForm = formService.createOrUpdateForm(form);

        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public List<Form> createPrograms(@RequestBody List<Form> Form) {
        return formService.saveAllForms(Form);
    }

    // Delete form by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable long id) {
        formService.deleteForm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
