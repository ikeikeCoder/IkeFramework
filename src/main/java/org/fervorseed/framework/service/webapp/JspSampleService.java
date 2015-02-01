package org.fervorseed.framework.service.webapp;

import java.util.List;

import org.fervorseed.framework.domain.webapp.JspSample;

public interface JspSampleService {
	public List<JspSample> selectUserList() throws Exception;
	
	public int insertUser(JspSample JspSample);
}
