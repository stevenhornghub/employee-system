package com.stevenhornghub.promotionrequest.services.implement;

import com.stevenhornghub.promotionrequest.exceptions.CannotBeNullException;
import com.stevenhornghub.promotionrequest.exceptions.DuplicateEntryException;
import com.stevenhornghub.promotionrequest.exceptions.IdDoesNotExistException;
import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.repositories.EmployeeRepository;
import com.stevenhornghub.promotionrequest.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employees saveEmployee(Employees employees) {
        boolean doesUsernameExist = employeeRepository.existsByUsername(employees.getUsername());
        boolean doesEmailExist = employeeRepository.existsByEmail(employees.getEmail());

        if (doesUsernameExist) {
            throw new DuplicateEntryException("Username already exists");
        }
        if (doesEmailExist) {
            throw new DuplicateEntryException("Email already exists");
        }


        return employeeRepository.save(employees);
    }

    @Override
    public Optional<Employees> fetchEmployeeInfo(Long id) {
        Optional<Employees> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new IdDoesNotExistException(String.format("Id %d does not exist", id));
        }
        return employee;

    }

    @Override
    public Employees updateEmployee(Employees employees) {

        try {
            return employeeRepository.save(employees);
        } catch (Exception e) {
            throw new CannotBeNullException("Unknown error occurred");
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        boolean doesExist = employeeRepository.existsById(id);
        if (!doesExist) {
            throw new IdDoesNotExistException("Id does not exist");
        }
        employeeRepository.deleteById(id);

    }

}