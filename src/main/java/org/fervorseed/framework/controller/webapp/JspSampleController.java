package org.fervorseed.framework.controller.webapp;

import org.fervorseed.framework.service.webapp.JspSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspSampleController {
	
	@Autowired
	JspSampleService jspSampleService;
	
	@RequestMapping("/userPage")
	public String userPage () {
		
		return "userPage";
	}
	
	@RequestMapping("/sampleSitemesh")
	public String sampleSitemesh() {
		return "sampleSitemesh";
	}
}
