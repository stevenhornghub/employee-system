package com.stevenhornghub.promotionrequest.repositories;

import com.stevenhornghub.promotionrequest.models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employees, Long>{

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}

