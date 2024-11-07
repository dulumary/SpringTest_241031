package com.marondal.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mvc.domain.Seller;
import com.marondal.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/create")
	public String  createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		return "redirect:/mvc/seller/info";
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		return "mvc/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		Seller seller = null;
		if(id == null) {			
			seller = sellerService.getLastSeller();
			
		} else {
			seller = sellerService.getSeller(id);
		}
		
		model.addAttribute("seller", seller);
		
		return "mvc/sellerInfo";
	}
	

}
