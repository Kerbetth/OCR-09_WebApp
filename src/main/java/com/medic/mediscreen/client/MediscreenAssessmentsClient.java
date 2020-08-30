package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;


@FeignClient(name = "mediscreenAssessment", url = "localhost:8083")
public interface MediscreenAssessmentsClient {

    @GetMapping(value = "/assess")
    String getAssessment(Patient patient);

}
