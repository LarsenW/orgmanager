package com.orgmanager.persistence.dao;

import java.util.List;

import com.orgmanager.common.entity.Company;

public interface CompanyDao {

	public void persist(Company company);

	public void update(Company company);

	public void delete(Company company);

	public List<Company> findAll();

	public Company getById(Long id);

	public List<Company> getAllByParentId(Long Id);
}
