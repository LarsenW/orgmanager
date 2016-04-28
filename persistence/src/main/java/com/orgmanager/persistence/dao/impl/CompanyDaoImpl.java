package com.orgmanager.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.orgmanager.common.entity.Company;
import com.orgmanager.persistence.dao.CompanyDao;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void persist(Company company) {

		entityManager.persist(company);
	}

	@Override
	public void update(Company company) {
		entityManager.merge(company);

	}

	@Override
	public void delete(Company company) {
		entityManager.remove(company);

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
