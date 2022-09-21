package vw.abc.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import vw.abc.entity.LoanApplication;
import vw.abc.models.LoanApplicationDto;

@Component
public class LoanApplicationMapper {

	/**
	 * Converting Entity to Dto object
	 * 
	 * @param entity
	 * @return
	 */
	public LoanApplicationDto toDto(LoanApplication entity) {
		LoanApplicationDto dto = new LoanApplicationDto();
		dto.setAddress(entity.getAddress());
		dto.setAdhar(entity.getAdhar());
		dto.setEmail(entity.getEmail());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setMobileNumber(entity.getMobileNumber());
		dto.setSalary(entity.getSalary());
		dto.setId(entity.getId());
		dto.setLoanTypeId(entity.getLoanTypeId());
		dto.setPan(entity.getPan());
		dto.setStatus(entity.getStatus());
		dto.setRemark(entity.getRemark());

		return dto;
	}

	/**
	 * Converts Dto to Entity
	 * 
	 * @param LoanApplicationDto
	 * @return LoanApplication
	 */
	public LoanApplication toEntity(LoanApplicationDto dto) {
		LoanApplication entity = new LoanApplication();
		entity.setAddress(dto.getAddress());
		entity.setAdhar(dto.getAdhar());
		entity.setEmail(dto.getEmail());
		entity.setLoanTypeId(dto.getLoanTypeId());
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		entity.setMobileNumber(dto.getMobileNumber());
		entity.setSalary(dto.getSalary());
		entity.setPan(dto.getPan());
		entity.setRemark(dto.getRemark());
		entity.setStatus(dto.getStatus());

		return entity;
	}

	/**
	 * converting list of entities to Dto List
	 * 
	 * @param listEntity
	 * @return
	 */
	public List<LoanApplicationDto> toListDto(List<LoanApplication> listEntity) {
		return listEntity.stream().map(this::toDto).collect(Collectors.toList());

	}
}
