package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.PatHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatHistory_Repository extends CrudRepository<PatHistory, Long> {
    List<PatHistory> findByPatient(int id);
}
