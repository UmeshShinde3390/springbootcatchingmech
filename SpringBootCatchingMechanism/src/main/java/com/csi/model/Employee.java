package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue

    private int empId;

    @Size(min = 2 , message = "Name must be atleast 2 characters")
    private String empName;

    private String empAddress;

    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    @Column(unique = true)
    private long empContactNumber;

    @Email(message = "EmailId must be valid")
    private String empEmailId;

    @Size(min = 4 , message = "Password must be atleast 4 characters")
    private String empPassword;
}
