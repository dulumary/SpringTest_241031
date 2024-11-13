package com.marondal.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@GetMapping("/list")
	public String weatherHistory() {
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		return "thymeleaf/weather/input";
	}

}
