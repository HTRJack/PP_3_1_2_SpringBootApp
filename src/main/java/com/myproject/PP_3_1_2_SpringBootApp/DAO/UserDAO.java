package com.myproject.PP_3_1_2_SpringBootApp.DAO;



import com.myproject.PP_3_1_2_SpringBootApp.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    void delete(User user);

    void edit(User user);

    User getById(long id);


}
