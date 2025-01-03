package com.davv.NAAC.service;

import com.davv.NAAC.model.Form;

import java.util.List;

public interface FormService {

    List<Form> getAllForms();

    Form getFormById(long id);

    Form createOrUpdateForm(Form form);

    void deleteForm(long id);


    List<Form> saveAllForms(List<Form> Forms);
}
