package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatient", url = "localhost:8081")
public interface MediscreenPatientClient {

    @GetMapping(value = "/Patients")
    List<Patient> getPatientList();

    @GetMapping(value = "/Patient/{id}")
    Patient getPatientById(@PathVariable("id") int id);

    @GetMapping(value = "/Patient/{familyName}")
    int getIdByFamilyName(@PathVariable("familyName") String familyName);

    @PostMapping(value = "/Patient/add")
    void addAPatient(@RequestBody Patient patient);

    @PutMapping(value = "/Patient/set")
    void setAPatient(@RequestBody Patient patient);

    @DeleteMapping(value = "/Patient/del")
    void deleteAPatient(@RequestParam int patientId);
}
