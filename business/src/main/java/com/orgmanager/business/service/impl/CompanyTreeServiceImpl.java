package com.orgmanager.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.business.service.CompanyTreeService;
import com.orgmanager.common.dto.CompanyTreeDto;
import com.orgmanager.common.entity.Company;
import com.orgmanager.persistence.dao.CompanyDao;

@Service
@Transactional
public class CompanyTreeServiceImpl implements CompanyTreeService {
	@Autowired
	CompanyDao companyDao;

	@Override
	public CompanyTreeDto getCompanyTree(Company company) {
		CompanyTreeDto companyTreeDto = new CompanyTreeDto();
		companyTreeDto.setCompany(company);
		List<Company> subsidiaryCompanies = getCompaniesByParentId(company.getId());
		List<CompanyTreeDto> subsidiaryCompanyTrees = new ArrayList<>();
		if (subsidiaryCompanies.size()==0) {
			companyTreeDto.setCompany(company);
			companyTreeDto.setSubsidiaryCompanies(subsidiaryCompanyTrees);
			return companyTreeDto;
		} else {
			for (Company c : subsidiaryCompanies) {
				subsidiaryCompanyTrees.add(getCompanyTree(c));
			}
			companyTreeDto.setSubsidiaryCompanies(subsidiaryCompanyTrees);
			return companyTreeDto;
		}
	}

	public List<Company> getCompaniesByParentId(Long parentId) {
		return companyDao.getAllByParentId(parentId);
	}
}
