package com.medic.mediscreen.client;

import com.medic.mediscreen.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Patient_Repository extends CrudRepository<Patient, Long> {
    Optional<Patient> findByFamily(String Family);
    Optional<Patient> findByPatId(int patId);
    List<Patient> findAll();
}
