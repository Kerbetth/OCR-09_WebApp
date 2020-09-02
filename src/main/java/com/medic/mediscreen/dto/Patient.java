package com.medic.mediscreen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class Patient {

    @NotBlank
    Integer id;
    @NotBlank
    String family;
    @NotBlank
    String given;
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dob;
    @NotBlank
    char sex;
    String address;
    String phone;
}
