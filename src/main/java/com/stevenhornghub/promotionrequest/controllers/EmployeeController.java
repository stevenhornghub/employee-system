package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Steven Horng
 */


@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public Employees saveUser(@Valid @RequestBody Employees employees) {
        return employeeService.saveEmployee(employees);
    }

    @PostMapping("/search/{id}")
    public Optional<Employees> fetchInfoById(@Valid @PathVariable("id") Long id) {
        return employeeService.fetchEmployeeInfo(id);
    }

    @PutMapping("/update/{id}")
    public Employees updateEmployee(@Valid @PathVariable(value = "id") Long id,
                                    @RequestBody Employees employees) {
        employees.setId(id);
        return employeeService.updateEmployee(employees);

    }

    //Delete for Employees
    @DeleteMapping("delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted Successfully";
    }

}