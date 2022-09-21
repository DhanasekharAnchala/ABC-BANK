package vw.abc.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import vw.abc.models.LoanApplicationDto;
import vw.abc.service.LoanApplicationService;

/**
 * @author adsekhar
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class LoanControllerTest {

	@MockBean
	private LoanApplicationService loanApplicationService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void getStatusByLoanIdTest() throws Exception {

		LoanApplicationDto loanApplication = new LoanApplicationDto(1l, 1l, "dhana", "sekhar", "dhana@gmail.com", 20000,
				9999999999l, "bangalore", 123123333333l, "GBDSS9458", "Approved", "valid-Data");
		when(loanApplicationService.getStatusById(Mockito.any())).thenReturn(loanApplication);
		mockMvc.perform(get("/api/1")).andExpect(status().isOk())

				.andDo(print());
	}

	@Test
	void getAllTest() throws Exception {

		LoanApplicationDto loanApplication = new LoanApplicationDto(1l, 1l, "dhana", "sekhar", "dhana@gmail.com", 20000,
				9999999999l, "bangalore", 123123333333l, "GBDSS9458", "Approved", "Invalid-Data");
		LoanApplicationDto loanApplication1 = new LoanApplicationDto(1l, 1l, "sharma", "pallavi", "sunil@gmail.com", 20000,
				9999999999l, "bangalore", 123123333333l, "GBDSS9958", "Rejected", "Invalid-Data");
		List<LoanApplicationDto> loanApplicationList = new ArrayList<>();
		loanApplicationList.add(loanApplication);
		loanApplicationList.add(loanApplication1);
		when(loanApplicationService.getAllLoans()).thenReturn(loanApplicationList);
		mockMvc.perform(get("/api/getAll")).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(2))
				.andDo(print());
	}

	@Test
	void addLoanApplicationTest() throws Exception {

		LoanApplicationDto loanApplication = new LoanApplicationDto(1l, 1l, "dhana", "sekhar", "dhana@gmail.com", 20000,
				9999999999l, "bangalore", 123123333333l, "GBDSS9458", "Approved", "Invalid-Data");
		mockMvc.perform(post("/api/applyLoan").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(loanApplication))).andExpect(status().isOk()).andDo(print());
	}

}
