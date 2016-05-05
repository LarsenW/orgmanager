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
	public @ResponseBody void saveCompany(HttpServletRequest request) {
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setIncome(Double.valueOf(request.getParameter("income")));
		company.setParentId(Long.valueOf(request.getParameter("parentId")));
		companyService.persist(company);
	}

	@RequestMapping(value = "/get_companies", method = RequestMethod.GET)
	public @ResponseBody List<CompanyGridDto> getCompanies() {
		return companyGridService.getAllCompanies();
	}

	@RequestMapping(value = "/delete_{id}", method = RequestMethod.POST)
	public @ResponseBody void deleteCompany(@PathVariable Long id) {
		companyDeletingService.deleteCompanyById(id);
	}
}
