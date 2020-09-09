package com.medic.mediscreen.controllers;


import com.medic.mediscreen.client.MediscreenAssessmentsClient;
import com.medic.mediscreen.dto.PatHistory;
import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * -All the following endpoints execute CRUD request for the PatHistory Object
 */

@Controller
public class PatHistoryControllers {


    @Autowired
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;
    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;
    @Autowired
    private MediscreenAssessmentsClient mediscreenAssessmentsClient;

    @GetMapping(value = "/patients/patHistory/{id}/list")
    public String getHistories(@PathVariable("id") int id, Model model) {
        model.addAttribute("patHistories", mediscreenPatHistoryClient.getPatHistories(id));
        return "patHistory";
    }

    @GetMapping(value = "/patients/patHistory/{id}/add")
    public String addHistories(@PathVariable("id") int id, Model model) {
        model.addAttribute("patHistory", new PatHistory());
        return "addNotes";
    }

    @PostMapping(value = "/patients/patHistory/{id}/adding")
    public String addingHistories(@PathVariable("id") int id, PatHistory patHistory) {
        patHistory.setId(null);
        patHistory.setPatId(id);
        mediscreenPatHistoryClient.addAPatHistory(patHistory);
        return "redirect:/patients/patHistory/"+id+"/list";
    }

    @GetMapping(value = "/patients/patHistory/{id}/set/{noteId}")
    public String setHistories(@PathVariable("id") int id,@PathVariable("noteId") String noteId, @RequestParam String note, Model model) {
        model.addAttribute("patHistory", new PatHistory(noteId, note, id));
        return "setNotes";
    }

    @RequestMapping(value = "/patients/patHistory/setting")
    public String settingHistories(PatHistory patHistory) {
        mediscreenPatHistoryClient.setAPatHistory(patHistory);
        return "redirect:/patients/patHistory/"+patHistory.getPatId()+"/list";
    }

    @RequestMapping(value = "/patients/patHistory/{id}/del/{noteId}")
    public String deletePatient(@PathVariable("id") int id,@PathVariable("noteId") String noteId) {
        mediscreenPatHistoryClient.deleteAPatHistory(noteId);
        return "redirect:/patients/patHistory/"+id+"/list";
    }
}