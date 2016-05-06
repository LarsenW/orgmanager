package com.orgmanager.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.orgmanager.business.service.CompanyDeletingService;
import com.orgmanager.business.service.CompanyGridService;
import com.orgmanager.business.service.CompanyService;
import com.orgmanager.common.dto.CompanyErrorDto;
import com.orgmanager.common.dto.CompanyGridDto;
import com.orgmanager.common.entity.Company;

@Controller
public class IndexController {

	@Autowired
	CompanyService companyService;

	@Autowired
	CompanyGridService companyGridService;

	@Autowired
	CompanyDeletingService companyDeletingService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showMainPage(ModelMap model, HttpServletRequest request) {
		return new ModelAndView("Main");
	}

	@RequestMapping(value = "/save_company", method = RequestMethod.POST)
	public @ResponseBody CompanyErrorDto saveCompany(HttpServletRequest request) {
		CompanyErrorDto error = new CompanyErrorDto();
		Company company = new Company();
		boolean fail = false;
		String name = request.getParameter("name");
		boolean unique = companyService.getByName(name) == null ? true : false;
		try {
			Double income = Double.valueOf(request.getParameter("income"));
			if (income >= 0) {
				company.setIncome(income);
			} else {
				error.setInvalidIncome(true);
				fail = true;
			}
		} catch (NumberFormatException e) {
			error.setInvalidIncome(true);
			fail = true;
		}
		try {
			Long parentId = Long.valueOf(request.getParameter("parentId"));
			if (parentId == 0 || companyService.getById(parentId) != null) {
				company.setParentId(parentId);
			} else {
				error.setInvalidParentId(true);
				fail = true;
			}
		} catch (NumberFormatException e) {
			error.setInvalidParentId(true);
			fail = true;
		}
		if (name.length() > 1 && unique) {
			company.setName(name);
		} else {
			error.setInvalidName(true);
			fail = true;
		}

		if (!fail)

		{
			companyService.persist(company);
		}
		return error;

	}

	@RequestMapping(value = "/get_companies", method = RequestMethod.GET)
	public @ResponseBody List<CompanyGridDto> getCompanies() {
		return companyGridService.getAllCompanies();
	}

	@RequestMapping(value = "/get_company_{id}", method = RequestMethod.GET)
	public @ResponseBody Company getCompany(@PathVariable Long id) {
		Company company = companyService.getById(id);
		return company;
	}
	
	@RequestMapping(value="/update_company_{id}",method=RequestMethod.POST)
	public @ResponseBody CompanyErrorDto updateCompany(HttpServletRequest request,@PathVariable Long id){
		CompanyErrorDto error = new CompanyErrorDto();
		Company company = companyService.getById(id);
		boolean fail = false;
		String name = request.getParameter("name");
		boolean unique = (companyService.getByName(name) == null)||name.equals(company.getName()) ? true : false;
		try {
			Double income = Double.valueOf(request.getParameter("income"));
			if (income >= 0) {
				company.setIncome(income);
			} else {
				error.setInvalidIncome(true);
				fail = true;
			}
		} catch (NumberFormatException e) {
			error.setInvalidIncome(true);
			fail = true;
		}
		try {
			Long parentId = Long.valueOf(request.getParameter("parentId"));
			if (parentId == 0 || companyService.getById(parentId) != null) {
				company.setParentId(parentId);
			} else {
				error.setInvalidParentId(true);
				fail = true;
			}
		} catch (NumberFormatException e) {
			error.setInvalidParentId(true);
			fail = true;
		}
		if (name.length() > 1 && unique) {
			company.setName(name);
		} else {
			error.setInvalidName(true);
			fail = true;
		}

		if (!fail)

		{
			companyService.update(company);
		}
		return error;

	}
	
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
	public @ResponseBody void deleteCompany(@PathVariable Long id) {
		companyDeletingService.deleteCompanyById(id);
	}
}
