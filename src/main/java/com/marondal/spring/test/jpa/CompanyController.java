package com.marondal.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jpa.domain.Company;
import com.marondal.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		Company company1 = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		
		Company company2 = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		
		companyList.add(company1);
		companyList.add(company2);
		
		return companyList;
	}
	
	@ResponseBody
	@GetMapping("update")
	public Company updateCompany() {
		
		// id 8인 회사 정보에서 규모를 중소기업, 사원수를 34명으로 수정
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		
		// id가 8인 회사 정보 삭제
		companyService.deleteCompany(8);
		
		return "수행완료";
		
	}
	

}
