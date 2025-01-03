package com.davv.NAAC.service;

import com.davv.NAAC.model.login_data;
import com.davv.NAAC.repository.login_data_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Login_data_service_impl implements Login_data_service{

    @Autowired
    private login_data_repo loginDataRepository;

    @Override
    public login_data saveLoginData(login_data loginData) {
        return loginDataRepository.save(loginData);
    }

    @Override
    public login_data findLoginDataById(String login_id) {
        Optional<login_data> loginData = loginDataRepository.findById(login_id);
        return loginData.orElse(null); // Return null if not found
    }

    @Override
    public login_data updateLoginData(String login_id, login_data loginData) {
        Optional<login_data> existingLoginData = loginDataRepository.findById(login_id);
        if (existingLoginData.isPresent()) {
            login_data updatedLoginData = existingLoginData.get();
            updatedLoginData.setPassword(loginData.getPassword());
            return loginDataRepository.save(updatedLoginData);
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public void deleteLoginDataById(String login_id) {
        loginDataRepository.deleteById(login_id);
    }

    @Override
    public List<login_data> findAllLoginData() {
        return loginDataRepository.findAll();
    }

    @Override
    public String checklogin_data(login_data loginData) {
        // Attempt to find the login data by ID
        Optional<login_data> ldataOptional = loginDataRepository.findById(loginData.getLogin_id());

        // If the login ID does not exist, throw an exception
        if (ldataOptional.isEmpty()) {
            throw new RuntimeException("User not found with login ID: " + loginData.getLogin_id());
        }

        // Get the found login data
        login_data ldata = ldataOptional.get();

        // Check if the password matches
        if (!ldata.getPassword().equals(loginData.getPassword())) {
            throw new RuntimeException("Invalid password for login ID: " + loginData.getLogin_id());
        }

        // If everything is correct, return the login ID
        return ldata.getLogin_id();
    }
}
