package org.fervorseed.framework.service.webapp.impl;

import java.util.List;

import org.fervorseed.framework.domain.webapp.JspSample;
import org.fervorseed.framework.mapper.webapp.jspSampleMapper;
import org.fervorseed.framework.service.webapp.JspSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JspSampleServiceImpl implements JspSampleService{
	
	@Autowired
	jspSampleMapper jspSampleMapper;

	@Override
	public List<JspSample> selectUserList() throws Exception{
		
		return jspSampleMapper.selectUserList();
	}

	@Override
	public int insertUser(JspSample JspSample) {
		jspSampleMapper.insertUser(JspSample);
		return jspSampleMapper.insertUser(JspSample);
	}

}
