package com.orgmanager.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgmanager.business.service.CompanyGridService;
import com.orgmanager.business.service.CompanyService;
import com.orgmanager.business.service.TotalCompanyIncomeCountingService;
import com.orgmanager.common.dto.CompanyGridDto;
import com.orgmanager.common.entity.Company;
import com.orgmanager.common.enums.CompanyType;
import com.orgmanager.common.mapper.CompanyGridMapper;

@Service
public class CompanyGridServiceImpl implements CompanyGridService {
	@Autowired
	private CompanyService companyService;

	@Autowired
	private TotalCompanyIncomeCountingService totalCompanyIncomeCountingService;

	public List<CompanyGridDto> getAllCompanies() {
		CompanyGridMapper mapper = new CompanyGridMapper();
		List<Company> companiesList = companyService.findAll();
		List<CompanyGridDto> companiesDtoList = new ArrayList<>();
		for (Company c : companiesList) {
			CompanyType companyType;
			if (c.getParentId() == 0 || c.getParentId() == null) {
				companyType = CompanyType.MAIN;
			} else {
				companyType = CompanyType.SUBSIDIARY;
			}
			companiesDtoList
					.add(mapper.entityToDto(c, totalCompanyIncomeCountingService.getTotalIncome(c), companyType));
		}
		return companiesDtoList;
	}
}
