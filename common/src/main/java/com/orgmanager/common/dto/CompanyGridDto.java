package com.orgmanager.common.dto;

import com.orgmanager.common.enums.CompanyType;

public class CompanyGridDto {

	private Long id;

	private String name;

	private CompanyType companyType;

	private Double income;

	private Double totalIncome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}
}
