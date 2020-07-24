package com.medic.mediscreen.controllers;


import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.domain.Patient;
import com.medic.mediscreen.repositories.MediscreenPatHistoryClient;
import com.medic.mediscreen.repositories.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class PatHistoryControllers {


    @Autowired
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;


    @GetMapping("/patHistory/get")
    public String userPage(Model model) {
        return "UserPage";
    }

    @PostMapping("/patHistory/add")
    public String userPage(PatHistory patHistory) {
        mediscreenPatHistoryClient.addAPatHistory(patHistory);
        return "UserPage";
    }

}
