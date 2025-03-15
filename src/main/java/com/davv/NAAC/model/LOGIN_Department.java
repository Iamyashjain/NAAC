package com.davv.NAAC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LOGIN_Department {

    String id;
    String name;
    List<LOGIN_Form> forms;
}