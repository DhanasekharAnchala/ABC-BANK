package vw.abc.service;

import java.util.List;

import vw.abc.models.LoanApplicationDto;

public interface LoanApplicationService {

	LoanApplicationDto getStatusById(Long loanId);

	LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplication);

	List<LoanApplicationDto> getAllLoans();

}
