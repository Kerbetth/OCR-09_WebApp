package com.medic.mediscreen.controllers;


import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class PatHistoryControllers {


    @Autowired
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;
    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;

    @GetMapping(value = "/patients/patHistory/{id}/list")
    public String getHistories(@PathVariable("id") int id, Model model) {
        model.addAttribute("patHistories", mediscreenPatHistoryClient.getPatHistoryList(id));
        return "patHistory";
    }

    @GetMapping(value = "/patients/patHistory/{id}/add")
    public String addHistories(@PathVariable("id") int id, Model model) {
        model.addAttribute("patHistory", new PatHistory());
        return "addNotes";
    }

    @PostMapping(value = "/patients/patHistory/{id}/adding")
    public String addingHistories(@PathVariable("id") int id, PatHistory patHistory) {
        mediscreenPatHistoryClient.addAPatHistory(id, patHistory);
        return "redirect:/patients/patHistory/"+id+"/list";
    }
}