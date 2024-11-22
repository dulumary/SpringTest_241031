package com.marondal.spring.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jpa.domain.Recruit;
import com.marondal.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/read")
@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/1")
	public Recruit recruit1() {
		// id가 8인 공고 
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
	}

	
	@ResponseBody
	@GetMapping("/2")
	public List<Recruit> recruit2(@RequestParam("companyId") int companyId) {
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		
		return recruitList;
	}
	
	
	
	
	
	
	
	
	
}
