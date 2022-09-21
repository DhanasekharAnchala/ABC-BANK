package vw.abc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import vw.abc.entity.LoanApplication;
import vw.abc.mapper.LoanApplicationMapper;
import vw.abc.models.LoanApplicationDto;
import vw.abc.repository.LoanApplicationRepository;

@ExtendWith(MockitoExtension.class)
class LoanApplicationServiceImplTest {

	@Mock
	private LoanApplicationRepository loanApplicationRepository;

	@InjectMocks
	private LoanApplicationServiceImpl loanApplicationServiceImpl;

	@Spy
	private LoanApplicationMapper loanApplicationMapper;

	@Test
	void getStatusByIdTest() throws Exception {
		LoanApplication loanApplication = getLoanApplication();
		Mockito.when(loanApplicationRepository.findById(Mockito.any())).thenReturn(Optional.of(loanApplication));
		LoanApplicationDto loanApplicationDto = loanApplicationServiceImpl.getStatusById(1l);
		assertEquals(loanApplication.getFirstname(), loanApplicationDto.getFirstname());
	}

	
	/*
	 * @Test void getStatusByIdNullTest() throws Exception { LoanApplication
	 * loanApplication = null;
	 * 
	 * Mockito.when(loanApplicationRepository.findById(Mockito.any())).thenReturn(
	 * Optional.ofNullable(loanApplication)); LoanApplicationDto loanApplicationDto
	 * = loanApplicationServiceImpl.getStatusById(1l);
	 * assertTrue(loanApplicationDto.equals("300-Loan Not Found")); }
	 */
	 

	@Test
	void getAllTest() throws Exception {

		List<LoanApplication> loanApplicationList = new ArrayList<>();
		loanApplicationList.add(getLoanApplication());
		loanApplicationList.add(getLoanApplication());
		Mockito.when(loanApplicationRepository.findAll()).thenReturn(loanApplicationList);
		List<LoanApplicationDto> loanApplicationDto = (List<LoanApplicationDto>) loanApplicationServiceImpl
				.getAllLoans();
		assertEquals(loanApplicationDto.size(), loanApplicationList.size());
	}

	@Test
	void addLoanApplicationTest() throws Exception {
		LoanApplicationDto loanApplicationDto = new LoanApplicationDto(1l,1l, "dhana", "sekhar", "dhana@gmail.com", 20000,
				9999999999l, "bangalore", 123123333333l, "GBDSS9458", "Approved", "valid-Data");
		LoanApplication loanApplication = loanApplicationMapper.toEntity(loanApplicationDto);
		Mockito.when(loanApplicationRepository.save(Mockito.any())).thenReturn(loanApplication);

		// when - action or the behaviour that we are going test
		LoanApplicationDto loanApplicationDto1 = loanApplicationServiceImpl.addLoanApplication(loanApplicationDto);

		// then -verify the output assertEquals(loanApplication.getAddress(),
		assertEquals(loanApplication.getFirstname(), loanApplicationDto1.getFirstname());

	}

	private LoanApplication getLoanApplication() {
		return new LoanApplication(1l,1l, "dhana", "sekhar", "dhana@gmail.com", 20000, 9999999999l, "bangalore",
				123123333333l, "GBDSS9458", "Approved", "valid-Data");
	}

}
