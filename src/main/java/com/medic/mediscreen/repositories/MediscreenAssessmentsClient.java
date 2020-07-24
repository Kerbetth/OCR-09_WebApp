package com.medic.mediscreen.repositories;

import com.medic.mediscreen.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreen_patient", url = "localhost:8081")
public interface MediscreenAssessmentsClient {

    @GetMapping(value = "/asses/{id}")
    String assesbyId(@PathVariable("id") int id);

    @GetMapping(value = "/asses/{familyName}")
    void assesByFamilyName(String familyName);

}
