package vw.abc.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import vw.abc.entity.LoanApplication;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoanApplicationRepositoryTest {

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;

	@Test
	@Order(1)
	@Rollback(value = false)
	void addLoanApplication() {
		LoanApplication loanApplication = LoanApplication.builder().id(1l).firstname("dhana").lastname("sekhar")
				.email("dhana@gmail.com").salary(20000).mobileNumber(9999999999l).address("pune").adhar(6364565365436l)
				.pan("GBDSS9458").status("Approved").remark("valid-Data").build();

		loanApplicationRepository.save(loanApplication);
		assertThat(loanApplication).isNotNull();
		assertThat(loanApplication.getId()).isPositive();
	}

	@Test
	@Order(2)
	void findByIdTest() {

		Optional<LoanApplication> loanApplication = loanApplicationRepository.findById(1l);

		Assertions.assertThat(loanApplication.get().getId()).isEqualTo(1l);
	}

	@Test
	@Order(3)
	void findAllTest() {

		List<LoanApplication> loanApplications = (List<LoanApplication>) loanApplicationRepository.findAll();

		Assertions.assertThat(loanApplications).isNotEmpty();
	}
}
