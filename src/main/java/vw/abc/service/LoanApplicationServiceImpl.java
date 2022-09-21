package vw.abc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vw.abc.entity.LoanApplication;
import vw.abc.exceptions.ErrorCodes;
import vw.abc.exceptions.LoanApplicationNotfoundException;
import vw.abc.mapper.LoanApplicationMapper;
import vw.abc.models.LoanApplicationDto;
import vw.abc.repository.LoanApplicationRepository;

/**
 * Service class for Loan Application which is used to create and get Loan
 * Applications
 * 
 * @author adsekhar
 *
 */
@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	LoanApplicationRepository loanApplicationRepository;

	@Autowired
	LoanApplicationMapper loanApplicationMapper;

	/**
	 * Gives LoanApplicationDto based on loanId
	 *
	 * @param loanId
	 * @return LoanApplicationDto
	 */
	@Override
	public LoanApplicationDto getStatusById(Long loanId) {

		Optional<LoanApplication> loanApplication = loanApplicationRepository.findById(loanId);
		if (loanApplication.isPresent()) {
			return loanApplicationMapper.toDto(loanApplication.get());
		} else {
			throw new LoanApplicationNotfoundException(ErrorCodes.Loan_Not_Found.getCode(),
					ErrorCodes.Loan_Not_Found.getMessage());
		}

	}

	/**
	 * Save LoanApplicationDto
	 *
	 * @param LoanApplicationDto
	 * @return LoanApplicationDto
	 */
	@Override
	public LoanApplicationDto addLoanApplication(LoanApplicationDto loanApplicationDto) {
		Optional<LoanApplication> loanApplication1 = loanApplicationRepository
				.findById(loanApplicationDto.getLoanTypeId());
		if (loanApplication1.isPresent() && (loanApplicationDto.getPan().equals(loanApplication1.get().getPan()))) {
			throw new LoanApplicationNotfoundException(ErrorCodes.Loan_Already_Exits.getCode(),
					ErrorCodes.Loan_Already_Exits.getMessage());
		}
		LoanApplication loanApplication = loanApplicationMapper.toEntity(loanApplicationDto);
		LoanApplication returnedLoanApplication = loanApplicationRepository.save(loanApplication);
		return loanApplicationMapper.toDto(returnedLoanApplication);
	}

	/**
	 * returns all the list of LoanApplicationDto
	 *
	 * @return List<LoanApplicationDto>
	 */
	@Override
	public List<LoanApplicationDto> getAllLoans() {
		List<LoanApplication> loanApplication = (List<LoanApplication>) loanApplicationRepository.findAll();
		return loanApplicationMapper.toListDto(loanApplication);

	}

}
