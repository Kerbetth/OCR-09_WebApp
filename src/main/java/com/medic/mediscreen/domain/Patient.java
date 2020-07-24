package com.medic.mediscreen.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotBlank;

public class Patient {
    @GeneratedValue
    Integer patId;
    @NotBlank
    String family;
    @NotBlank
    String given;
    @NotBlank
    Date dob;
    @NotBlank
    char sex;
    @NotBlank
    String address;
    String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Set<PatHistory> patHistories;
}
