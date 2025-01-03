package com.davv.NAAC.controller;

import com.davv.NAAC.model.*;
import com.davv.NAAC.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class NewLoginController {
    @Autowired
    LoginDataController ldc = new LoginDataController();
    @Autowired
    DepartmentController dc = new DepartmentController();
    @Autowired
    private FormService formService;

    @PostMapping("/check")
    public LOGIN_Department check_login_and_give_response(@RequestBody login_data lt)
    {
        String response = ldc.checkLoginData(lt);
        Map<String,String> map = new HashMap<>();
        Department dept= dc.getDepartment(response);




        List<Form> forms_list=formService.getAllForms();
        List<LOGIN_Form> listofloginforms=new ArrayList<>();
        for(Form form_x:forms_list) {

            List<LOGIN_field> listoffields =new ArrayList<>();
            Long id=form_x.getForm_id();
            Form form = formService.getFormById(id);
          //  System.out.println(form.getAttributes());
            int i=0;
            for(Map.Entry<String,String> entry:form.getAttributes().entrySet()) {
                listoffields.add(new LOGIN_field(i,entry.getKey(),entry.getValue()));
                i++;
            }
            LOGIN_Form login_form=new LOGIN_Form(1,form_x.getForm_id(),form_x.getForm_name(),listoffields);
            listofloginforms.add(login_form);



        }
        System.out.println(listofloginforms);
        LOGIN_Department loginDepartment=new LOGIN_Department(dept.getDepartment_id(), dept.getDepartment_name(), listofloginforms);

        return loginDepartment;
    }


}
