package com.davv.NAAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Courses_offered {
    @Id
    String cid;
    String department_id;  // Foreign key relationship
    int Total_seats;
    int seats_admitted;
    String course_type;
    String course_name;

}
