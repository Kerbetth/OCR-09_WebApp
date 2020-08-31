package com.medic.mediscreen.controllers;


import com.medic.mediscreen.client.MediscreenAssessmentsClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@RestController
public class AssessmentsControllers {

    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;
    @Autowired
    private MediscreenAssessmentsClient mediscreenAssessmentsClient;

    @GetMapping("/asses/id")
    public String assesById(@RequestParam int id) {
        return mediscreenAssessmentsClient.getAssessment(mediscreenPatientClient.getPatientById(id));
    }

    @GetMapping("/asses/familyName")
    public String assesByFamilyName(@RequestParam String familyName) {

        return mediscreenAssessmentsClient.getAssessment(mediscreenPatientClient.getPatientByFamilyName(familyName));
    }
}
