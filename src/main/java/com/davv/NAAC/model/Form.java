package com.davv.NAAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {
    @Id
    Long form_id;
    String form_name;

    String published_date;


    String deadline;

    @ElementCollection
    @CollectionTable(name = "form_department", joinColumns = @JoinColumn(name = "form_id"))
    @Column(name = "department_id")
    private List<String> department_ids;

    @ElementCollection
    @CollectionTable(name = "form_attributes", joinColumns = @JoinColumn(name = "form_id"))
    @MapKeyColumn(name = "field_name") // Key for field names
    @Column(name = "field_data_type")  // Value for data types
    private Map<String, String> attributes;

}
