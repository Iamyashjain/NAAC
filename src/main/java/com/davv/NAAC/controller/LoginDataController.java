package com.davv.NAAC.controller;

import com.davv.NAAC.model.login_data;
import com.davv.NAAC.service.Login_data_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginDataController {

    @Autowired
    private Login_data_service loginDataService;

    // Create a new login data entry
    @PostMapping
    public login_data createLoginData(@RequestBody login_data loginData) {
        return loginDataService.saveLoginData(loginData);
    }

    @PostMapping("/check_login")
    public String checkLoginData(@RequestBody login_data loginData) {
        try {
            // Call the service method to validate login credentials
            return loginDataService.checklogin_data(loginData); // Return login ID on success
        } catch (RuntimeException e) {
            // Handle known exceptions by returning specific messages
            if (e.getMessage().contains("User not found")) {
                return "Error: User not found";
            } else if (e.getMessage().contains("Invalid password")) {
                return "Error: Invalid password";
            }

            // For other types of runtime exceptions, return a generic error message
            return "Error: An unexpected error occurred.";
        }
    }


    // Get login data by ID
    @GetMapping("/{login_id}")
    public login_data getLoginData(@PathVariable String login_id) {
        return loginDataService.findLoginDataById(login_id);
    }

    // Update existing login data by ID
    @PutMapping("/{login_id}")
    public login_data updateLoginData(@PathVariable String login_id, @RequestBody login_data loginData) {
        return loginDataService.updateLoginData(login_id, loginData);
    }

    // Delete login data by ID
    @DeleteMapping("/{login_id}")
    public void deleteLoginData(@PathVariable String login_id) {
        loginDataService.deleteLoginDataById(login_id);
    }

    // Get all login data
    @GetMapping
    public List<login_data> getAllLoginData() {
        return loginDataService.findAllLoginData();
    }
}
