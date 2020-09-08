package com.medic.mediscreen.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class HomeControllers {

    @RequestMapping(value = "/")
    public String getLog(Model model) {
        return "homePage";
    }

}
