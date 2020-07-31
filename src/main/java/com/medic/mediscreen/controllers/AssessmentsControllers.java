package com.medic.mediscreen.controllers;


import com.medic.mediscreen.repositories.MediscreenPatHistoryClient;
import com.medic.mediscreen.repositories.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class AssessmentsControllers {

    @Autowired
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;
    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;

    @GetMapping("/asses/{id}")
    public String assesById(@PathVariable int id) {
        mediscreenPatHistoryClient.getAssessment(id);
        return "bidList/add";
    }

    @GetMapping("/asses/{familyName}")
    public String assesByFamilyName(@PathVariable String familyName) {
        return mediscreenPatHistoryClient.getAssessment(mediscreenPatientClient.getIdByFamilyName(familyName));
    }
}
