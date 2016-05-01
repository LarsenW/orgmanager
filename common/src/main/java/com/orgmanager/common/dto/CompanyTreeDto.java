package com.orgmanager.common.dto;

import java.util.List;

import com.orgmanager.common.entity.Company;

public class CompanyTreeDto {

	private Company company;

	private List<CompanyTreeDto> subsidiaryCompanies;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<CompanyTreeDto> getSubsidiaryCompanies() {
		return subsidiaryCompanies;
	}

	public void setSubsidiaryCompanies(List<CompanyTreeDto> subsidiaryCompanies) {
		this.subsidiaryCompanies = subsidiaryCompanies;
	}
	
}
