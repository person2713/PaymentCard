package com.team.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nick on 13.03.2017.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String startPage() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/registration")
    public String registrationPage() {
        return "registration";
    }
}
