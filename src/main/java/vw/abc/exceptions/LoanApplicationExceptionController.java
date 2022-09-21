package vw.abc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoanApplicationExceptionController {

	@ExceptionHandler(value = LoanApplicationNotfoundException.class)
	public ResponseEntity<Object> exception(LoanApplicationNotfoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
	}
}
