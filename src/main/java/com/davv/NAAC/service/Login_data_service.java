package com.davv.NAAC.service;

import com.davv.NAAC.model.login_data;

import java.util.List;

public interface Login_data_service {
    login_data saveLoginData(login_data loginData);

    // Find login data by login ID
    login_data findLoginDataById(String login_id);

    // Update existing login data
    login_data updateLoginData(String login_id, login_data loginData);

    // Delete login data by ID
    void deleteLoginDataById(String login_id);

    // List all login data
    List<login_data> findAllLoginData();
    //checking the user
    String checklogin_data(login_data loginData);

}
