package com.stevenhornghub.promotionrequest.repositories;

import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ManagerRepository extends PagingAndSortingRepository<User, Long> {

    @Query("from Employee")
    List<Employees> findAllUsers();

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
