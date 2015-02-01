package org.fervorseed.framework.mapper.webapp;

import java.util.List;

import org.fervorseed.framework.domain.webapp.JspSample;
import org.springframework.stereotype.Repository;

@Repository
public interface jspSampleMapper {
	public List<JspSample> selectUserList();
	
	public int insertUser(JspSample JspSample);
}
