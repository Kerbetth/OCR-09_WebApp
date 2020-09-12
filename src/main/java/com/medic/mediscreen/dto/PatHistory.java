package com.medic.mediscreen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatHistory {

    String id;
    @NotEmpty(message = "note is mandatory")
    String note;
    @NotEmpty(message = "no patient id affiliate to the note")
    Integer patId;
}
