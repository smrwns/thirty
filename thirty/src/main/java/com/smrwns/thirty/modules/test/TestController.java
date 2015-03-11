package com.smrwns.thirty.modules.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/html5")
	public void html5() {
		System.out.println("test html5 executed!");
	}
}
