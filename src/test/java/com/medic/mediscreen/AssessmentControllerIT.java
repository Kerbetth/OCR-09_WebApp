package com.medic.mediscreen;

import com.medic.mediscreen.client.MediscreenAssessmentsClient;
import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.client.MediscreenPatientClient;
import com.medic.mediscreen.domain.PatHistory;
import com.medic.mediscreen.domain.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class AssessmentControllerIT {

    @MockBean(name = "com.medic.mediscreen.client.MediscreenAssessmentsClient")
    private MediscreenAssessmentsClient mediscreenAssessmentsClient;

    @MockBean(name = "com.medic.mediscreen.client.MediscreenPatientClient")
    private MediscreenPatientClient mediscreenPatientClient;

	@Autowired
	MockMvc mockMvc;

    PatHistory patHistory = new PatHistory();

    @BeforeEach
    void setup() {
	patHistory.setId(1);
	patHistory.setPatient(new Patient());
	patHistory.setNote("a note");
    }

    @Test
    public void getAllPatHistoryListForm() throws Exception {
        when(mediscreenAssessmentsClient.getAssessment(any())).thenReturn("a response");
        mockMvc.perform(get("/asses/id")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "1")
        )
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void addPatHistoryForm() throws Exception {
        when(mediscreenAssessmentsClient.getAssessment(any())).thenReturn("a response");
        when(mediscreenPatientClient.getPatientByFamilyName(anyString())).thenReturn(new Patient());
        mockMvc.perform(get("/asses/familyName")
                .contentType(MediaType.APPLICATION_JSON)
                .param("familyName", "aName")
        )
                .andExpect(status().isOk());
    }

}
