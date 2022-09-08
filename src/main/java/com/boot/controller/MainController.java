package com.boot.controller;

import com.boot.model.User;
import com.boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/home")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "mainPage";
    }

    @GetMapping("/create")
    public String getForm(Model model) {
        model.addAttribute("newUser", new User());
        return "createUser";
    }

    @PostMapping("/home")
    public String saveNewUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id,
                                 Model model) {
       model.addAttribute("user", userService.findUserById(id));
        return "userById";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id) {
        userService.updateUser(user, id);
        return "redirect:/home";
    }
}
