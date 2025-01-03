package com.davv.NAAC.service;

import com.davv.NAAC.model.Form;
import com.davv.NAAC.repository.FormRepository;
import com.davv.NAAC.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    @Override
    public Form getFormById(long id) {
        return formRepository.findById(id).orElse(null);
    }

    @Override
    public Form createOrUpdateForm(Form form) {
        return formRepository.save(form);
    }

    @Override
    public void deleteForm(long id) {
        formRepository.deleteById(id);
    }

    @Override
    public List<Form> saveAllForms(List<Form> Forms) {
        return formRepository.saveAll(Forms);
    }
}
