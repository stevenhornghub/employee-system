package com.stevenhornghub.promotionrequest.services.implement;

import com.stevenhornghub.promotionrequest.exceptions.PasswordIsIncorrectException;
import com.stevenhornghub.promotionrequest.exceptions.UsernameDoesNotExistException;
import com.stevenhornghub.promotionrequest.exceptions.WrongCredentialsException;
import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.repositories.LoginRepository;
import com.stevenhornghub.promotionrequest.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        boolean credentialsIsCorrect = loginRepository.existsByUsernameAndPassword(username, password);

        if (!credentialsIsCorrect){
            throw new WrongCredentialsException("Wrong Credentials!");
        }

        return loginRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Boolean findByUserName(String username) {
        boolean doesExist = loginRepository.existsByUsername(username);
        if (!doesExist) {
            throw new UsernameDoesNotExistException("Username does not exist");
        }
        return true;
    }

    @Override
    public Boolean checkPassword(String password) {
        boolean isCorrect = loginRepository.existsByPassword(password);
        if (!isCorrect) {
            throw new PasswordIsIncorrectException("Password Incorrect");
        }
        return true;
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        Optional<User> name = loginRepository.findByFirstName(firstName);
        return name;
    }

}
