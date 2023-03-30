package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.models.Managers;
import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.services.EmployeeService;
import com.stevenhornghub.promotionrequest.services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Steven Horng
 */


@RestController
@AllArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final EmployeeService employeeService;


    //Create employees
    @PostMapping("/manager/create-employee")
    public Employees saveEmployee(@RequestBody Employees employees) {
        return employeeService.saveEmployee(employees);

    }

    //Create for Managers only
    @PostMapping("/manager")
    public Managers saveUser(@Valid @RequestBody Managers managers) {
        return managerService.saveUser(managers);
    }

//    //Read for Managers only
//    @GetMapping("/manager/manager-list")
//    public ResponseEntity<List<Managers>> fetchManagerList(@Valid @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
//        return new ResponseEntity<>(managerService.fetchManagerList(pageNumber, pageSize), HttpStatus.OK);
//    }

    //Read all Users
    @GetMapping("/manager/user-list")
    public ResponseEntity<Page<User>> findAllUsers(@Valid @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(managerService.fetchUserLists(pageNumber, pageSize), HttpStatus.OK);
    }


    //Update for Managers only
    @PutMapping("/manager/{id}")
    public ResponseEntity<Managers> updateUser(@Valid @PathVariable(value = "id") Long id,
                                               @RequestBody Managers managers) {
        managers.setId(id);
        managerService.updateUser(managers);
        return ResponseEntity.ok(managers);
    }

    //Update for Employees
    @PutMapping("/manager/update-employee/{id}")
    public ResponseEntity<Employees> updateEmployee(@Valid @PathVariable(value = "id") Long id,
                                                    @RequestBody Employees employees) {
        employees.setId(id);
        employeeService.updateEmployee(employees);
        return ResponseEntity.ok(employees);
    }

    //Delete for Managers only
    @DeleteMapping("manager/{id}")
    public String deleteManagerById(@Valid @PathVariable("id") Long id) {
        managerService.deleteManagerById(id);
        return "Deleted Successfully";
    }

    //Delete for Employees
    @DeleteMapping("manager/delete-employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted Successfully";
    }
}
