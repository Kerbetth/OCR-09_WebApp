package com.medic.mediscreen.client;

import com.medic.mediscreen.dto.PatHistory;
import com.medic.mediscreen.dto.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "mediscreenPatHistory", url = "${PRACTIONER_URI}", primary = false)
public interface MediscreenPatHistoryClient {

    @GetMapping(value = "/patHistory/getPatHistories")
    List<PatHistory> getPatHistories(@RequestParam int id);

    @GetMapping(value = "/patHistory/getNotes")
    List<String> getNotes(@RequestParam int id);

    @PostMapping(value = "/patHistory/add")
    void addAPatHistory(@RequestBody PatHistory patHistory);

    @PutMapping(value = "/patHistory/set", consumes = "application/json")
    void setAPatHistory(@RequestBody PatHistory patHistory);

    @DeleteMapping(value = "/patHistory/del", consumes = "application/json")
    void deleteAPatHistory(@RequestParam String noteId);

}
