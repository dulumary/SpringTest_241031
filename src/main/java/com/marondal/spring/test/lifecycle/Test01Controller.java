package com.marondal.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01Controller {
	
	@ResponseBody
	@RequestMapping("/lifecycle/test01/1")
	public String stringResponse() {
		return "<h2>테스트 프로젝트 완성</h2><h4>해당 프로젝트를 통해 문제풀이를 진행합니다.</h4>";
	}

}
