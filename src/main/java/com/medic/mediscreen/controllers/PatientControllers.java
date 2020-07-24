package com.medic.mediscreen.controllers;


import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.domain.Patient;
import com.medic.mediscreen.repositories.MediscreenPatHistoryClient;
import com.medic.mediscreen.repositories.MediscreenPatientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * -the root of the url give link to login or create an account
 * -userHome url is the main page of connected users
 */

@Controller
public class PatientControllers {

    @Autowired
    private MediscreenPatientClient mediscreenPatientClient;

    @GetMapping("/patient/list")
    public String listPatient(Model model) {
        model.addAttribute("patients", mediscreenPatientClient.getPatientList());
        return "patient";
    }

    @GetMapping("/patient/add")
    public String addPatient(Patient bid, Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/patient/adding")
    public String validate(Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patient/add";
        }
        mediscreenPatientClient.addAPatient(patient);
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/set/{id}")
    public String setPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", mediscreenPatientClient.getPatient(id));
        return "setPatient";
    }

    @PostMapping("/patient/setting")
    public String settingPatient(Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patient/set";
        }
        mediscreenPatientClient.setAPatient(patient);
        return "redirect:/patient/list";
    }

    @DeleteMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        mediscreenPatientClient.deleteAPatient(id);
        return "redirect:/patient/list";
    }
}
