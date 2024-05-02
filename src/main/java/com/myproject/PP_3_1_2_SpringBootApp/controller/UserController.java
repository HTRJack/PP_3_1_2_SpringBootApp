package com.myproject.PP_3_1_2_SpringBootApp.controller;

import com.myproject.PP_3_1_2_SpringBootApp.model.User;
import com.myproject.PP_3_1_2_SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public ModelAndView allUsers(@ModelAttribute("user") User user) {
        List<User> users = userService.getAllUsers();
        return new ModelAndView("users.html", "userList", users);
    }

    @GetMapping(value = "/editUser")
    public ModelAndView editPage(@RequestParam(value = "id") int id) {
        User user = userService.getById(id);
        return new ModelAndView("editUser.html", "user", user);
    }

    @PostMapping(value = "/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value = "/delete")
    public ModelAndView deleteUser(@RequestParam(value = "id") int id) {
        User user = userService.getById(id);
        userService.delete(user);
        return new ModelAndView("redirect:/");
    }


    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return new ModelAndView("redirect:/");
    }
}
