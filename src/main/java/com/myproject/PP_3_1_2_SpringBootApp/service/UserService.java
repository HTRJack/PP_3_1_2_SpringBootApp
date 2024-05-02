package com.myproject.PP_3_1_2_SpringBootApp.service;



import com.myproject.PP_3_1_2_SpringBootApp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void delete(User user);

    void edit(User user);

    User getById(long id);

}
