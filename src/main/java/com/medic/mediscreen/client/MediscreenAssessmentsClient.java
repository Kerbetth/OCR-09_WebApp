package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.AssessInfo;
import com.medic.mediscreen.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@FeignClient(name = "mediscreenAssessment", url = "${ASSESSMENT_URI}", primary = false)
public interface MediscreenAssessmentsClient {

    @PostMapping(value = "/assess")
    String getAssessment(@RequestBody AssessInfo assessInfo);

}
