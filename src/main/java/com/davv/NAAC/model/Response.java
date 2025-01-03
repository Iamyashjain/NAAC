package com.davv.NAAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long response_id;

    Long form_id;


    // Many responses can be submitted by one department
    private String department_id;

    // Date when the response was submitted
    private String submission_date_time;

    // The actual form responses, where key = field_name and value = the response provided
    @ElementCollection
    @CollectionTable(name = "response_fields", joinColumns = @JoinColumn(name = "response_id"))
    @MapKeyColumn(name = "field_name") // Key for field names
    @Column(name = "field_value")      // Value for user inputs
    private Map<String, String> fieldResponses;

}
