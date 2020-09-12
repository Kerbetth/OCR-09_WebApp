package com.medic.mediscreen.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * -the root url give access to the intro page
 */

@Controller
public class HomeControllers {

    @RequestMapping(value = "/")
    public String getLog(Model model) {
        return "homePage";
    }

}
