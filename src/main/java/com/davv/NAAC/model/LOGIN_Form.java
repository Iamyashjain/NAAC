package com.davv.NAAC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LOGIN_Form {

    int response_count;
    Long form_id;
    String name;

    List<LOGIN_field> fields;
}