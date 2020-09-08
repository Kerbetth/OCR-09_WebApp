package com.medic.mediscreen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class Patient {


    Integer id;
    @NotEmpty(message = "family name is mandatory")
    @Size(min = 3, max = 20)
    String family;
    @NotEmpty(message = "given name is mandatory")
    @Size(min = 3, max = 20)
    String given;
    @NotNull(message = "date of birth is mandatory")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dob;
    @NotNull(message = "gender is mandatory")
    char sex;
    String address;
    String phone;
}
