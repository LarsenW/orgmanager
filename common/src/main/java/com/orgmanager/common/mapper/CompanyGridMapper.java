package com.orgmanager.common.mapper;

import com.orgmanager.common.dto.CompanyGridDto;
import com.orgmanager.common.entity.Company;
import com.orgmanager.common.enums.CompanyType;

public class CompanyGridMapper {
	
	public CompanyGridDto entityToDto(Company company, Double totalIncome, CompanyType companyType) {
		CompanyGridDto companyGridDto = new CompanyGridDto();
		companyGridDto.setName(company.getName());
		companyGridDto.setIncome(company.getIncome());
		companyGridDto.setTotalIncome(totalIncome);
		companyGridDto.setCompanyType(companyType);
		return companyGridDto;
	}
}
