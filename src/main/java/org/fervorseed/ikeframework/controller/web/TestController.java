package org.fervorseed.ikeframework.controller.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fervorseed.ikeframework.domain.web.Test;
import org.fervorseed.ikeframework.service.web.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;

	@RequestMapping("/test")
	public String getTest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("message", "Hello Spring Java Config");
		
		return "showMessage";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public Map<String, String> getTest2(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		HashMap<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("name", "이병석");
		returnMap.put("age", "29");
		
		return returnMap;
	}
	
	@RequestMapping("/getCabinetInfo")
	@ResponseBody
	public Test getCabinetInfo(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		return testService.getCabinetInfo();
	}
}
