package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.models.Employees;
import com.stevenhornghub.promotionrequest.models.Managers;
import com.stevenhornghub.promotionrequest.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManagerService {


    //Save
    Managers saveUser(Managers managers);

    //Read
    Page<User> fetchUserLists(int pageNumber, int pageSize);
//    List<Managers> getManagerList(int pageNumber, int pageSize);

    //Update
    Managers updateUser(Managers managers);

    //Delete Managers
    void deleteManagerById(Long id);

    List<Employees> findAllUsers();

}
