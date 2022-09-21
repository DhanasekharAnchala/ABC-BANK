package vw.abc.exceptions;

public enum ErrorCodes {

	Loan_Not_Found(300, "Loan Not Found"),
	Loan_Already_Exits(301, "Loan_Already_Applied with these details");

	ErrorCodes(int statusCode, String message) {
		this.code = statusCode;
		this.message = message;

	}

	int code;
	String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return getCode() + ":" + getMessage();
	}

}

