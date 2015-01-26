package org.fervorseed.ikeframework.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String getTest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("message", "Hello Spring Java Config");
		
		return "showMessage";
	}
}
