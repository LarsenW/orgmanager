package com.orgmanager.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgmanager.business.service.CompanyTreeService;
import com.orgmanager.business.service.TotalCompanyIncomeCountingService;
import com.orgmanager.common.dto.CompanyTreeDto;
import com.orgmanager.common.entity.Company;

@Service
public class TotalCompanyIncomeCountingServiceImpl implements TotalCompanyIncomeCountingService {
	@Autowired
	CompanyTreeService companyTreeService;

	@Override
	public Double getTotalIncome(Company company) {
		CompanyTreeDto tree = companyTreeService.getCompanyTree(company);
		Double income = tree.getCompany().getIncome();
		List<CompanyTreeDto> subtrees = tree.getSubsidiaryCompanies();
		if (subtrees.size() > 0) {
			for (CompanyTreeDto t : subtrees) {
				income += getTotalIncome(t.getCompany());
			}
			return income;
		} else {
			return income;
		}
	}
}
