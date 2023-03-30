package com.stevenhornghub.promotionrequest.services.implement;

import com.stevenhornghub.promotionrequest.exceptions.CannotBeNullException;
import com.stevenhornghub.promotionrequest.exceptions.DuplicateEntryException;
import com.stevenhornghub.promotionrequest.exceptions.IdDoesNotExistException;
import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.models.Managers;
import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.repositories.ManagerRepository;
import com.stevenhornghub.promotionrequest.services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;


    @Override
    public Managers saveUser(Managers managers) {
        boolean doesUsernameExists = managerRepository.existsByUsername(managers.getUsername());
        boolean doesEmailExists = managerRepository.existsByEmail(managers.getEmail());
        if (doesUsernameExists) {
            throw new DuplicateEntryException("Username already exists");
        }
        if (doesEmailExists) {
            throw new DuplicateEntryException("Email already exists");
        }

        return managerRepository.save(managers);

    }

    @Override
    public Page<User> fetchUserLists(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return managerRepository.findAll(pages);
    }

//    @Override
//    public List<Managers> getManagerList(int pageNumber, int pageSize) {
//        Pageable pages = PageRequest.of(pageNumber, pageSize);
//        return managerRepository.findAll(pages).getContent();;
//    }


    @Override
    public Managers updateUser(Managers managers) {

        try {
            return managerRepository.save(managers);
        } catch (Exception e) {
            throw new CannotBeNullException("Unknown error occurred");
        }
    }

    @Override
    public void deleteManagerById(Long id) {

        boolean doesExist = managerRepository.existsById(id);
        if (!doesExist) {
            throw new IdDoesNotExistException("Account have already deleted/not yet registered");
        }
        managerRepository.deleteById(id);

    }

    @Override
    public List<Employees> findAllUsers() {
        return managerRepository.findAllUsers();
    }
}
