package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.models.Employees;

import java.util.Optional;

public interface EmployeeService {

    //Create Employee
    Employees saveEmployee(Employees employees);

    //Read an individual employee
    Optional<Employees> fetchEmployeeInfo(Long id);

    //Update
    Employees updateEmployee(Employees employees);

    //Delete
    void deleteEmployeeById(Long id);

}

