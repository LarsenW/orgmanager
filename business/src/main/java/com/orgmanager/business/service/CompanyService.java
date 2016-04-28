package com.orgmanager.business.service;

import java.util.List;

import com.orgmanager.common.entity.Company;

public interface CompanyService {
	public void persist(Company company);

	public void update(Company company);

	public void delete(Company company);

	public List<Company> findAll();

	public Company getById(Long id);
}
