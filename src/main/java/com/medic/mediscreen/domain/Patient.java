package com.medic.mediscreen.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PATIENT")
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotBlank
    String family;
    @NotBlank
    String given;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dob;
    @NotBlank
    char sex;
    @NotBlank
    String address;
    String phone;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "patient")
    private Set<PatHistory> patHistories;
}
