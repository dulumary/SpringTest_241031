package com.marondal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mybatis.domain.RealEstate;
import com.marondal.spring.test.mybatis.service.RealEstateService;

@RequestMapping("/mybatis/realestate/select")
@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		// parameter 로 전달 받은 id와 일치하는 부동산 정보 얻어오기 
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		// parameter로 받은 월세 금액보다 더 낮은 매물 정보 얻어오기 
		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<RealEstate> realEstateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		// parameter로 전달받은 넓이 보다 크고, 가격 보다 작은 매물 얻어오기 
		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaAndPrice(area, price);
		
		return realEstateList;
	}

}





