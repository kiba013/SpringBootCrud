package com.boot.controller;

import com.boot.model.User;
import com.boot.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/home")
    public String getMainPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "mainPage";
    }

    @GetMapping("/create")
    public String getForm(Model model) {
        model.addAttribute("newUser", new User());
        return "createUser";
    }

    @PostMapping("/home")
    public String saveNewUser(@ModelAttribute("newUser") User user) {
        userRepository.save(user);
        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "userById";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/home";
    }

}
