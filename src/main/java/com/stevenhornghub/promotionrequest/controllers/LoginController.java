package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven Horng
 * */

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String checkPassword(@RequestBody User user) {
        loginService.findByUserName(user.getUsername());
        loginService.checkPassword(user.getPassword());
        loginService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return "Logged in successfully";
    }
}
