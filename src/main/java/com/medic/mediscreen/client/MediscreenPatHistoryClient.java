package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.CreatePatHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatHistory", url = "localhost:8082", primary = false)
public interface MediscreenPatHistoryClient {

    @GetMapping(value = "/patHistory")
    List<CreatePatHistory> getPatHistoryList(@RequestParam int id);

    @PostMapping(value = "/patHistory/add")
    void addAPatHistory(@RequestParam int id, @RequestBody CreatePatHistory patHistory);

}
