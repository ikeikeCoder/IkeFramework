package org.fervorseed.framework.controller.webapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fervorseed.framework.service.webapp.JspSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspSampleController {
	
	@Autowired
	JspSampleService jspSampleService;
	
	@RequestMapping("/selectUserList")
	public String selectUserList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		model.addAttribute("userList",jspSampleService.selectUserList());
		
		return "userList";
	}
}
