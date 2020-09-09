package com.medic.mediscreen.controllers;


import com.medic.mediscreen.dto.Patient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * -All the following endpoints execute CRUD request for the Patient Object
 */

@Controller
public class PatientControllers {

    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;

    @GetMapping(value = "/patients/list")
    public String listPatient(Model model) {
        model.addAttribute("patients", mediscreenPatientClient.getPatientList());
        return "patient";
    }

    @GetMapping(value = "/patients/patient/{familyName}")
    public Patient getPatientByFamilyName(@PathVariable("familyName") String familyName) {
        return mediscreenPatientClient.getPatientByFamilyName(familyName);
    }

    @GetMapping(value = "/patients/add")
    public String addPatient( Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping(value = "/patients/adding")
    public String validate(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "addPatient";
        }
        mediscreenPatientClient.addAPatient(patient);
        return "redirect:/patients/list";
    }

    @GetMapping(value = "/patients/set/{id}")
    public String setPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", mediscreenPatientClient.getPatientById(id));
        return "setPatient";
    }

    @RequestMapping(value = "/patients/setting/{id}")
    public String settingPatient(@PathVariable("id") int id, @Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "setPatient";
        }
        patient.setId(id);
        mediscreenPatientClient.setAPatient(patient);
        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/patients/del/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        mediscreenPatientClient.deleteAPatient(id);
        return "redirect:/patients/list";
    }

}
