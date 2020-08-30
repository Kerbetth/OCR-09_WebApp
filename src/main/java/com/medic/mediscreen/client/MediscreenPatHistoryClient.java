package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatHistory", url = "localhost:8082")
public interface MediscreenPatHistoryClient {

    @GetMapping(value = "/patHistory")
    List<PatHistory> getPatHistoryList(@RequestParam int id);

    @PostMapping(value = "/patHistory/add")
    void addAPatHistory(@RequestParam int id, @RequestBody PatHistory patHistory);

}
