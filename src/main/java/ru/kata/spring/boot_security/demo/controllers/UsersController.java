package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping("")
    public String user(Model model, Principal principal) {
        model.addAttribute("sayname", principal.getName());
        return "user";
    }

    @GetMapping("/readonly")
    public String readonly(Model model, Principal principal) {
        model.addAttribute("saynamereadonly", principal.getName());
        return "readonly";
    }
}
