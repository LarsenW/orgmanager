package com.orgmanager.business.service;

import com.orgmanager.common.dto.CompanyTreeDto;
import com.orgmanager.common.entity.Company;

public interface CompanyTreeService {
	
	public CompanyTreeDto getCompanyTree(Company company);
}
