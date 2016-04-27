package com.orgmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orgmanager.dao.CompanyDao;
import com.orgmanager.entity.Company;
import com.orgmanager.service.CompanyService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
