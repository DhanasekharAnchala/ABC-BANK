package vw.abc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationDto {
	private Long id;
	private long loanTypeId;
	private String firstname;
	private String lastname;
	private String email;
	private double salary;
	private long mobileNumber;
	private String address;
	private long adhar;
	private String pan;
	private String status;
	private String remark;
}
