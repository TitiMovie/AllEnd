package com.movietime.controller;

import com.movietime.entity.User;
import com.movietime.service.UserService;
import com.movietime.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/register")
public class RegisterPageController {
    @Autowired
    UserService us;

    @RequestMapping(method = RequestMethod.GET)
    public String get_register(Model model) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post_register(String firstName, String lastName, String email,
                                boolean newsletter, String password, String confirmPassword, Model model, HttpSession session) {
        if (Validator.checkPassword(password) &&
                Validator.checkEmail(email) &&
                Validator.checkName(firstName) &&
                Validator.checkName(lastName) &&
                password.equals(confirmPassword) &&
                !us.isRegistered(email)) {
            us.registerUser(email, password, firstName, lastName);
            User user = us.getUserInstance(email, password);
            session.setAttribute("user", user);
            return "redirect:/";
        }
        return "redirect:/register";
    }
}
