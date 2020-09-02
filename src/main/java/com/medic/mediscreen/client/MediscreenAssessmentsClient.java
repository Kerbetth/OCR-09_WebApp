package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "mediscreenAssessment", url = "localhost:8083", primary = false)
public interface MediscreenAssessmentsClient {

    @GetMapping(value = "/assess")
    String getAssessment(Patient patient);

}
