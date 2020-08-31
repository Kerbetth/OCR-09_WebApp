package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatient", url = "localhost:8081", primary = false)
public interface MediscreenPatientClient {

    @GetMapping(value = "/Patients")
    List<Patient> getPatientList();

    @GetMapping(value = "/Patient/{id}")
    Patient getPatientById(@PathVariable("id") int id);

    @GetMapping(value = "/Patient/{familyName}")
    Patient getPatientByFamilyName(@PathVariable("familyName") String familyName);

    @PostMapping(value = "/Patient/add", consumes = "application/json")
    void addAPatient(@RequestBody Patient patient);

    @RequestMapping(value = "/Patient/set", consumes = "application/json")
    void setAPatient(@RequestBody Patient patient);

    @RequestMapping(value = "/Patient/del", consumes = "application/json")
    void deleteAPatient(@RequestParam int patientId);
}
