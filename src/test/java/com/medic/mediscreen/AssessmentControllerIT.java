package com.medic.mediscreen;

import com.medic.mediscreen.client.MediscreenAssessmentsClient;
import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import com.medic.mediscreen.dto.CreatePatHistory;
import com.medic.mediscreen.dto.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class AssessmentControllerIT {

    @MockBean(name = "com.medic.mediscreen.client.MediscreenAssessmentsClient")
    private MediscreenAssessmentsClient mediscreenAssessmentsClient;

    @MockBean(name = "com.medic.mediscreen.client.MediscreenPatientClient")
    private MediscreenPatientClient mediscreenPatientClient;
    @MockBean(name = "com.medic.mediscreen.client.MediscreenPatHistoryClient")
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;

    @Autowired
    MockMvc mockMvc;

    CreatePatHistory patHistory = new CreatePatHistory();
    Patient patient = new Patient();

    @BeforeEach
    void setup() {
        patHistory.setId(1);
        patHistory.setNote("a note");
        patient.setId(1);
        patient.setDob(LocalDate.of(2000, 02, 02));
        patient.setAddress("an address");
        patient.setFamily("test");
        patient.setSex('M');
    }

    @Test
    public void assessByIdShouldReturnOk() throws Exception {
        when(mediscreenPatientClient.getPatientById(anyInt())).thenReturn(patient);
        when(mediscreenAssessmentsClient.getAssessment(any())).thenReturn("a response");
        when(mediscreenPatHistoryClient.getNotes(anyInt())).thenReturn(Collections.singletonList("a note"));
        mockMvc.perform(get("/assess/id")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void assesByFamilyNameShouldReturnOk() throws Exception {

        when(mediscreenAssessmentsClient.getAssessment(any())).thenReturn("a response");
        when(mediscreenPatientClient.getPatientByFamilyName(anyString())).thenReturn(patient);
        when(mediscreenPatHistoryClient.getNotes(anyInt())).thenReturn(Collections.singletonList("a note"));
        mockMvc.perform(get("/assess/familyName")
                .contentType(MediaType.APPLICATION_JSON)
                .param("familyName", "aName")
        )
                .andExpect(status().isOk());
    }

}
