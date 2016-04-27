package com.orgmanager.dao;

import java.util.List;

import com.orgmanager.entity.Company;

public interface CompanyDao {

	public void persist(Company company);

	public void update(Company company);

	public void delete(Company company);

	public List<Company> findAll();

	public Company getById(Long id);
}
