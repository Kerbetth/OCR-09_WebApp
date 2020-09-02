package com.medic.mediscreen.controllers;


import com.medic.mediscreen.dto.CreatePatient;
import com.medic.mediscreen.client.MediscreenPatientClient;
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

    @GetMapping(value = "/patients/list")
    public String listPatient(Model model) {
        model.addAttribute("patients", mediscreenPatientClient.getPatientList());
        return "patient";
    }

    @GetMapping(value = "/patients/patient/{familyName}")
    public CreatePatient getPatientByFamilyName(@PathVariable("familyName") String familyName) {
        return mediscreenPatientClient.getPatientByFamilyName(familyName);
    }

    @GetMapping(value = "/patients/add")
    public String addPatient( Model model) {
        model.addAttribute("patient", new CreatePatient());
        return "addPatient";
    }

    @PostMapping(value = "/patients/adding")
    public String validate(CreatePatient createPatient, BindingResult result) {
        if (result.hasErrors()) {
            return "addPatient";
        }
        mediscreenPatientClient.addAPatient(createPatient);
        return "redirect:/patients/list";
    }

    @GetMapping(value = "/patients/set/{id}")
    public String setPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", mediscreenPatientClient.getPatientById(id));
        return "setPatient";
    }

    @RequestMapping(value = "/patients/setting/{id}")
    public String settingPatient(@PathVariable("id") Integer id, CreatePatient createPatient, BindingResult result) {
        if (result.hasErrors()) {
            return "setPatient";
        }
        createPatient.setId(id);
        mediscreenPatientClient.setAPatient(createPatient);
        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/patients/del/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        mediscreenPatientClient.deleteAPatient(id);
        return "redirect:/patients/list";
    }

}
