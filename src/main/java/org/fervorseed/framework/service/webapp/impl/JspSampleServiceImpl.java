package org.fervorseed.framework.service.webapp.impl;

import java.util.List;

import org.fervorseed.framework.domain.webapp.JspSample;
import org.fervorseed.framework.mapper.webapp.JspSampleMapper;
import org.fervorseed.framework.service.webapp.JspSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JspSampleServiceImpl implements JspSampleService{
	
	@Autowired
	JspSampleMapper JspSampleMapper;

	@Override
	public List<JspSample> selectUserList() throws Exception{
		
		return JspSampleMapper.selectUserList();
	}

	@Override
	public int insertUser(JspSample JspSample) {
		return JspSampleMapper.insertUser(JspSample);
	}

}
