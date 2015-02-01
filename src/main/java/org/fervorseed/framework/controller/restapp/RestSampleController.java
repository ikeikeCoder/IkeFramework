package org.fervorseed.framework.controller.restapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fervorseed.framework.domain.restapp.RestSample;
import org.fervorseed.framework.service.restapp.RestSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestSampleController {
	
	@Autowired
	RestSampleService restSampleService;
	
	@RequestMapping("/selectUserList")
	@ResponseBody
	public List<RestSample> selectUserList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		return restSampleService.selectUserList();
	}
}
