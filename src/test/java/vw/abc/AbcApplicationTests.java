package vw.abc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vw.abc.controller.LoanController;
import vw.abc.service.LoanApplicationService;

@SpringBootTest
class AbcApplicationTests {

	 @Autowired
	    private LoanController loanController;

	    @Autowired
	    private LoanApplicationService loanApplicationService;

	    @Test
	    void contextLoads() throws Exception {
	        assertThat(loanController).isNotNull();
	        assertThat(loanApplicationService).isNotNull();
	    }

}
