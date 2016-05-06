package com.orgmanager.business.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orgmanager.business.service.CompanyGridService;
import com.orgmanager.business.service.CompanyService;
import com.orgmanager.common.dto.CompanyGridDto;
import com.orgmanager.common.entity.Company;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		CompanyService cs = (CompanyService) context.getBean("companyServiceImpl");
		Company company = cs.getByName("bloha2");

		System.out.println(company==null);
		// CompanyTreeService cts = (CompanyTreeService)
		// context.getBean("companyTreeServiceImpl");
		// CompanyTreeDto ctdto = cts.getCompanyTree(company);
		// System.out.println(ctdto);

		// TotalCompanyIncomeCountingService income =
		// (TotalCompanyIncomeCountingService) context
		// .getBean("totalCompanyIncomeCountingServiceImpl");
		// System.out.println(income.getTotalIncome(company));
		// CompanyGridService cgs = (CompanyGridService)
		// context.getBean("companyGridServiceImpl");
		// List<CompanyGridDto> cgdto = cgs.getAllCompanies();
	}
}
