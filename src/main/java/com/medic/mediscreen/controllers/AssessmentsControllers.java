package com.medic.mediscreen.controllers;


import com.medic.mediscreen.client.MediscreenAssessmentsClient;
import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import com.medic.mediscreen.dto.AssessInfo;
import com.medic.mediscreen.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

/**
 * -AssessmentsControllers are the endpoint sending request to the assessment service
 */

@RestController
public class AssessmentsControllers {

    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;
    @Autowired
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;
    @Autowired
    private MediscreenAssessmentsClient mediscreenAssessmentsClient;

    @GetMapping("/assess/id")
    public String assesById(@RequestParam int id) {
        Patient patient = mediscreenPatientClient.getPatientById(id);
        return mediscreenAssessmentsClient.getAssessment(
                new AssessInfo(
                        patient.getFamily(),
                        patient.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE),
                        patient.getSex(),
                        mediscreenPatHistoryClient.getNotes(id)));
    }

    @GetMapping("/assess/familyName")
    public String assesByFamilyName(@RequestParam String familyName) {
        Patient patient = mediscreenPatientClient.getPatientByFamilyName(familyName);
        return mediscreenAssessmentsClient.getAssessment(
                new AssessInfo(
                        patient.getFamily(),
                        patient.getDob().format(DateTimeFormatter.ISO_LOCAL_DATE),
                        patient.getSex(),
                        mediscreenPatHistoryClient.getNotes(patient.getId())));
    }
}
