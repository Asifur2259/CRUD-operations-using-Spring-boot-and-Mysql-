package com.rafin.crudpro.controller;


import com.rafin.crudpro.models.User;

import com.rafin.crudpro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    @Autowired
    private UserService userservice;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String ShowRegForm(Model model, User user){
       model.addAttribute("use", user);
       return "registration";
    }

    @PostMapping("/register")
    public String registration(User user){
        userservice.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/list")
    public String allUser(Model model){
        model.addAttribute("use", userservice.findAll());
        return "allUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userservice.deleteUser(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditForm(@PathVariable("id") Long id, Model model){
        User user = userservice.findOne(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid User Id "+id));
        model.addAttribute("use", user);
        return "updateUser";
    }

    @PostMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") Long id, User user){
        userservice.saveUser(user);
        return "redirect:/list";
    }
}
