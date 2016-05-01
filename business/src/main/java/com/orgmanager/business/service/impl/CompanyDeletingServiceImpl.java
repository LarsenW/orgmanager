package com.orgmanager.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.business.service.CompanyDeletingService;
import com.orgmanager.business.service.CompanyService;
import com.orgmanager.persistence.dao.CompanyDao;

@Service
@Transactional
public class CompanyDeletingServiceImpl implements CompanyDeletingService {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CompanyDao companyDao;

	@Override
	public void deleteCompanyById(Long id) {
		companyService.delete(companyService.getById(id));
		resetAllParentChains(id);
	}

	public void resetAllParentChains(Long id) {
		companyDao.resetAllParentIdChains(id);
	}
}
