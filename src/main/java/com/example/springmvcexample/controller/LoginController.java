package com.example.springmvcexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (Optional.ofNullable(username).filter(value -> !value.isBlank()).isPresent()
                || Optional.ofNullable(password).filter(value -> !value.isBlank()).isPresent()) {
            model.addAttribute("username", username);
            return "home";
        }
        model.addAttribute("errorMessage", "Debes introducir un nombre de usuario y una contraseña");
        return "error";
    }

}
