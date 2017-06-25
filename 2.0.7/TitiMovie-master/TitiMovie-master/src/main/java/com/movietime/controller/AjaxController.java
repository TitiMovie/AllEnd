package com.movietime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AjaxController {
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String get_logout(Model model, HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
