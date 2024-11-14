package com.marondal.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.thymeleaf.domain.Weather;
import com.marondal.spring.test.thymeleaf.service.WeatherService;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		
		// 날씨 기록 리스트를 얻어온다. 
		List<Weather> weatherList = weatherService.getWeatherList();
		
		// html에서 사용할 데이터 
		// model 에 추가
		model.addAttribute("weatherList", weatherList);
		
		return "thymeleaf/weather/list";
	}
	
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일")
//			@RequestParam("date") LocalDate date
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed) {
			 @ModelAttribute Weather weather){
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		int count = weatherService.addWeather(
				weather.getDate()
				, weather.getWeather()
				, weather.getTemperatures()
				, weather.getPrecipitation()
				, weather.getMicroDust()
				, weather.getWindSpeed());
		
		
		return "redirect:/thymeleaf/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		return "thymeleaf/weather/input";
	}
	
	

}
