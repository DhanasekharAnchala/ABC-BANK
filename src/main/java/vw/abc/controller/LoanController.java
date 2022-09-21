package vw.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vw.abc.models.LoanApplicationDto;
import vw.abc.service.LoanApplicationService;

/**
 * @author adsekhar
 * 
 *         This is used to manage loan applications of User like create loan
 *         application and know status of loan application
 *
 */
@RestController
@RequestMapping("/api")
public class LoanController {

	@Autowired
	private LoanApplicationService loanApplicationService;

	/**
	 * Returns LoanApplication based on loanId
	 * 
	 * @param loanId
	 * @return LoanApplicationDto
	 */
	@CrossOrigin("*")
	@GetMapping("/{loanId}")
	public ResponseEntity<LoanApplicationDto> getStatusByLoanId(@PathVariable Long loanId) {
		LoanApplicationDto loanApplication = loanApplicationService.getStatusById(loanId);
		return ResponseEntity.ok(loanApplication);
	}

	/**
	 * Returns all the Loan Applications
	 * 
	 * @return List<LoanApplicationDto>
	 */
	@CrossOrigin("*")
	@GetMapping("/getAll")
	public ResponseEntity<List<LoanApplicationDto>> getAllLoanApplications() {
		List<LoanApplicationDto> loanApplication = loanApplicationService.getAllLoans();
		return ResponseEntity.ok(loanApplication);
	}

	/**
	 * Saves Loan Applications
	 * 
	 * @param loanApplication
	 * @return LoanApplicationDto
	 */
	@CrossOrigin("*")
	@PostMapping("/applyLoan")
	public ResponseEntity<LoanApplicationDto> addLoanApplication(@RequestBody LoanApplicationDto loanApplication) {

		LoanApplicationDto addedLoan = loanApplicationService.addLoanApplication(loanApplication);
		return ResponseEntity.ok(addedLoan);
	}
}
