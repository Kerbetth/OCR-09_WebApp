package com.medic.mediscreen.repositories;

import com.medic.mediscreen.domain.PatHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "mediscreenPatHistory", url = "localhost:8082")
public interface MediscreenPatHistoryClient {

    @GetMapping(value = "/patHistories")
    List<PatHistory> getpatHistoryList();

    @GetMapping(value = "/patHistory/{id}")
    PatHistory getpatHistory(@PathVariable("id") int id);

    @PostMapping(value = "/patHistory/add")
    void addAPatHistory(@RequestBody PatHistory patHistory);

    @GetMapping(value = "/assess/{id}")
    String getAssessment(@PathVariable("id") int id);

}
