package com.smrwns.thirty.modules.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("/main")
	public void main() {
		System.out.println("main controller execute");
		mainService.main();
	}
}
