package org.fervorseed.framework.service.webapp.impl;

import org.fervorseed.framework.mapper.webapp.JspSampleMapper;
import org.fervorseed.framework.service.webapp.JspSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JspSampleServiceImpl implements JspSampleService{
	
	@Autowired
	JspSampleMapper JspSampleMapper;

}
