package vw.abc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Loan_Application")
public class LoanApplication implements Serializable {

	private static final long serialVersionUID = -1152779434213289790L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
