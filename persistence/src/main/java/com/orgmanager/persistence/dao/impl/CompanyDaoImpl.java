package com.orgmanager.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		Query query = entityManager.createQuery("Select c from Company c ");
		return query.getResultList();
	}

	@Override
	public Company getById(Long id) {
		return entityManager.find(Company.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllByParentId(Long id) {
		Query query = entityManager.createQuery("Select c from Company c where c.parentId= :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public void resetAllParentIdChains(Long id) {
		Query query = entityManager.createQuery("Update Company c set c.parentId=0 where c.parentId= :id ");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Company getByName(String name) {
		Query query = entityManager.createQuery("Select c from Company c where c.name= :name");
		query.setParameter("name", name);
		try {
			Company company = (Company) query.getSingleResult();
			return company;
		} catch (Exception e) {
			return null;
		}

	}

}
