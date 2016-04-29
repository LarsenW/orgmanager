package com.orgmanager.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.business.service.CompanyService;
import com.orgmanager.common.entity.Company;
import com.orgmanager.persistence.dao.CompanyDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;

	@Override
	public void persist(Company company) {
		companyDao.persist(company);

	}

	@Override
	public void update(Company company) {
		companyDao.update(company);
	}

	@Override
	public void delete(Company company) {
		companyDao.delete(company);

	}

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public Company getById(Long id) {
		return companyDao.getById(id);
	}

}
