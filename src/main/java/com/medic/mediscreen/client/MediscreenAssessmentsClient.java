package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.AssessInfo;
import com.medic.mediscreen.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@FeignClient(name = "mediscreenAssessment", url = "localhost:8083", primary = false)
public interface MediscreenAssessmentsClient {

    @GetMapping(value = "/assess")
    String getAssessment(@RequestBody AssessInfo assessInfo);

}
