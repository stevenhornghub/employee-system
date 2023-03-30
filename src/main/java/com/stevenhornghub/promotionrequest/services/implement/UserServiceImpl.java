package com.stevenhornghub.promotionrequest.services.implement;

import com.stevenhornghub.promotionrequest.exceptions.CannotBeNullException;
import com.stevenhornghub.promotionrequest.exceptions.DuplicateEntryException;
import com.stevenhornghub.promotionrequest.exceptions.IdDoesNotExistException;
import com.stevenhornghub.promotionrequest.exceptions.PasswordIsIncorrectException;
import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.repositories.UserRepository;
import com.stevenhornghub.promotionrequest.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) throws PasswordIsIncorrectException {
        boolean doesUsernameExists = userRepository.existsByUsername(user.getUsername());
        boolean doesEmailExists = userRepository.existsByEmail(user.getEmail());
        if (doesUsernameExists) {
            throw new DuplicateEntryException("Username already exists");
        }
        if (doesEmailExists) {
            throw new DuplicateEntryException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getListUser(){
        return (List<User>) userRepository.findAll();
    }


    @Override
    public Page<User> fetchUserList(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pages);
    }

    @Override
    public User updateUser(User user, Long Id) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CannotBeNullException("Unknown error occurred");
        }
    }

    @Override
    public void deleteUserById(Long id) {
        boolean doesExist = userRepository.existsById(id);
        if (!doesExist) {
            throw new IdDoesNotExistException("User not found");
        }
        userRepository.deleteById(id);

    }
}
