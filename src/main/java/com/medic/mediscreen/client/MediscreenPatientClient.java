package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.CreatePatient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatient", url = "localhost:8081", primary = false)
public interface MediscreenPatientClient {

    @GetMapping(value = "/Patients")
    List<CreatePatient> getPatientList();

    @GetMapping(value = "/Patient/id")
    CreatePatient getPatientById(@RequestParam int id);

    @GetMapping(value = "/Patient/familyName")
    CreatePatient getPatientByFamilyName(@RequestParam String familyName);

    @PostMapping(value = "/Patient/add", consumes = "application/json")
    void addAPatient(@RequestBody CreatePatient createPatient);

    @RequestMapping(value = "/Patient/set", consumes = "application/json")
    void setAPatient(@RequestBody CreatePatient createPatient);

    @RequestMapping(value = "/Patient/del", consumes = "application/json")
    void deleteAPatient(@RequestParam int patientId);
}
