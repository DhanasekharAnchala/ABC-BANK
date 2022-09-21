package vw.abc.exceptions;

public class LoanApplicationNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoanApplicationNotfoundException(int code, String message) {

		super(code+"-"+message);
	}
}
