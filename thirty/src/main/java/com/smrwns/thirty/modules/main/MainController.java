package com.smrwns.thirty.modules.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main")
	public void main() {
		System.out.println("main execute");
	}
}
