package com.marondal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.domain.Favorite;
import com.marondal.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		
		return "ajax/favorite/list";
	}
	
	// API
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	@GetMapping("/input")
	public String favoriteInput() {
		
		return "ajax/favorite/input";
		
	}
	
	// API
	@ResponseBody
	@PostMapping("/duplicate-url")
	public Map<String, Boolean>  isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		
		// 중복됨  {"isDuplicate":true}
		// 중복안됨  {"isDuplicate":false}
		Map<String, Boolean> resultMap = new HashMap<>();

		resultMap.put("isDuplicate", isDuplicate);
//		if(isDuplicate) {
//			resultMap.put("isDuplicate", true);
//		} else {
//			resultMap.put("isDuplicate", false);
//		}
		
		return resultMap;
		
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = favoriteService.deleteFavorite(id);
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	
	
	

}
