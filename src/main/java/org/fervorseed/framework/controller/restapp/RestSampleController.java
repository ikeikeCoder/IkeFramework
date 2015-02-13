package org.fervorseed.framework.controller.restapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fervorseed.framework.domain.restapp.RestSample;
import org.fervorseed.framework.service.restapp.RestSampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestSampleController {
	
	private static Logger logger = LoggerFactory.getLogger(RestSampleController.class);
	
	@Autowired
	RestSampleService restSampleService;
	
	/*
	 * 유저 목록 조회
	 * */
	@RequestMapping(value="/selectUserList", method=RequestMethod.GET)
	@ResponseBody
	public List<RestSample> selectUserList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return restSampleService.selectUserList();
	}
	
	/*
	 * 유저 등록
	 * */
	@RequestMapping(value="/insertUser", method=RequestMethod.PUT)
	@ResponseBody 
	public Map<String, Object> inserUser(@ModelAttribute("RestSample") RestSample user, HttpServletRequest request, HttpServletResponse response) {
		
		logger.info(user.toString());
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", (restSampleService.insertUser(user) == 1? true:false));
		return resultMap;
	}
	
	/*
	 * 유저 삭제
	 * */
	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
	@ResponseBody 
	public Map<String, Object> deleteUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		
		logger.info(id);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("success", (restSampleService.deleteUser(id) == 1? true:false));
		return resultMap;
	}
}
