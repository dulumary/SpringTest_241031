package com.marondal.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.ajax.domain.Booking;
import com.marondal.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/booking/main";
	}

}
