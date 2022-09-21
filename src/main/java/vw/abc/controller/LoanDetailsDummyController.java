package vw.abc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vw.abc.models.LoanDetails;
import vw.abc.utils.ConstantUtils;

@RestController
@RequestMapping("/api")
public class LoanDetailsDummyController {

	/**
	 * Returns all the Loan Applications
	 * 
	 * @return List<LoanDetails>
	 */
	@CrossOrigin("*")
	@GetMapping("/getAllTypeLoans")
	public ResponseEntity<List<LoanDetails>> getAllLoanApplications() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(1l,ConstantUtils.PERSONAL_LOAN, ConstantUtils.DURATION,ConstantUtils.PERSONAL_LOAN));
		loanDetailsList.add(new LoanDetails(2l, "CarLoan",ConstantUtils.DURATION, "CarLoan"));
		loanDetailsList.add(new LoanDetails(3l, "HomeLoan", "20 years", "Home"));
		loanDetailsList.add(new LoanDetails(4l, "Flexy Loan",ConstantUtils.DURATION, ConstantUtils.PERSONAL_LOAN));
		return ResponseEntity.ok(loanDetailsList);

	}

}
