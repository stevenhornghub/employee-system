package com.stevenhornghub.promotionrequest.repositories;

import com.stevenhornghub.promotionrequest.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    boolean existsById(Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
