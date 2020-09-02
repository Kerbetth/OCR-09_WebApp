package com.medic.mediscreen;

import com.medic.mediscreen.client.MediscreenPatHistoryClient;
import com.medic.mediscreen.dto.CreatePatHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class PatientControllerIT{

    @MockBean(name = "com.medic.mediscreen.client.MediscreenPatHistoryClient")
    private MediscreenPatHistoryClient mediscreenPatHistoryClient;

	@Autowired
	MockMvc mockMvc;

    CreatePatHistory patHistory = new CreatePatHistory();

    @BeforeEach
    void setup() {
	patHistory.setId(1);
	patHistory.setNote("a note");
    }

    @Test
    public void getAllPatHistoryListForm() throws Exception {
        mockMvc.perform(get("/patients/patHistory/1/list")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void addPatHistoryForm() throws Exception {
        mockMvc.perform(get("/patients/patHistory/1/add")
        )
                .andExpect(status().isOk());
    }

	@Test
	public void addingAPatHistory() throws Exception {
		mockMvc.perform(post("/patients/patHistory/1/adding")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("note", patHistory.getNote())
				.requestAttr("PatHistory", patHistory)
		)
				.andExpect(status().is3xxRedirection());
	}
}
