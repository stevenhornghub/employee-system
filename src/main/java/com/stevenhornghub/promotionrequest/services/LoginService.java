package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.models.User;

import java.util.Optional;

public interface LoginService {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Boolean findByUserName(String username);

    Boolean checkPassword(String username);

    Optional<User> findByFirstName(String firstName);


}
