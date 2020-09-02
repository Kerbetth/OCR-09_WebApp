package com.medic.mediscreen;

import com.medic.mediscreen.client.MediscreenPatientClient;
import com.medic.mediscreen.dto.CreatePatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class PatHistoyControllerIT {

    @MockBean(name = "com.medic.mediscreen.client.MediscreenPatientClient")
    private MediscreenPatientClient mediscreenPatientClient;

	@Autowired
	MockMvc mockMvc;

    CreatePatient createPatient = new CreatePatient();

    @BeforeEach
    void setup() {
	createPatient.setAddress("anAddress");
	createPatient.setDob(LocalDate.EPOCH);
	createPatient.setFamily("AFamilyName");
	createPatient.setGiven("AGivenName");
	createPatient.setPhone("000");
	createPatient.setSex('M');
    }

    @Test
    public void getAllPatientListForm() throws Exception {
        mockMvc.perform(get("/patients/list")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void addPatientForm() throws Exception {
        mockMvc.perform(get("/patients/add")
        )
                .andExpect(status().isOk());
    }

	@Test
	public void addingAPatient() throws Exception {
		mockMvc.perform(post("/patients/adding")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("address", createPatient.getAddress())
				.param("family", createPatient.getFamily())
				.param("given", createPatient.getGiven())
				.param("phone", createPatient.getPhone())
				.requestAttr("patient", createPatient)
		)
				.andExpect(status().is3xxRedirection());
	}

	@Test
	public void setAPatientForm() throws Exception {
		when(mediscreenPatientClient.getPatientById(1)).thenReturn(createPatient);
		mockMvc.perform(get("/patients/set/1")
		)
				.andExpect(status().isOk());
	}

	@Test
	public void settingAPatient() throws Exception {
		when(mediscreenPatientClient.getPatientById(1)).thenReturn(createPatient);
		mockMvc.perform(get("/patients/setting/1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("address", createPatient.getAddress())
				.param("family", createPatient.getFamily())
				.param("given", createPatient.getGiven())
				.param("phone", createPatient.getPhone())
				.requestAttr("patient", createPatient)
		)
				.andExpect(status().is3xxRedirection());
	}

	@Test
	public void deleteAPatient() throws Exception {
		doNothing().when(mediscreenPatientClient).deleteAPatient(anyInt());
		mockMvc.perform(get("/patients/del/1")
		)
				.andExpect(status().is3xxRedirection());
	}
}
