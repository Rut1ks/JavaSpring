package com.example.Test.controllers;

import com.example.Test.models.Role;
import com.example.Test.models.User;
import com.example.Test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String reg_view(Model model)
    {
        return "/registration";
    }
    @PostMapping("/registration")
    public String reg_action(User user, Model model)
    {
        User userFromDB = userRepository.findByLogin(user.getLogin());
        if(userFromDB !=null)
        {
            model.addAttribute("error","Такой пользователь существует");
            return "/registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
