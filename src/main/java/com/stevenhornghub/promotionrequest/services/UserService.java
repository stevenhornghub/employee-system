package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    //Save
    User saveUser(User user);

    //Read
    Page<User> fetchUserList(int pageNumber, int pageSize);

    //Update
    User updateUser(User user, Long Id);

    //Delete
    void deleteUserById(Long id);

    List<User> getListUser();
}