package com.davv.NAAC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Program {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;

    private String pcode;
    // Unique code for each program
    int SN;
    private String pname;
    private String deptID;

    String SRA;

}
