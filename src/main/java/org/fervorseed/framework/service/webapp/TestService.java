package org.fervorseed.framework.service.webapp;

import java.util.List;

import org.fervorseed.framework.domain.webapp.Test;

public interface TestService {
	public List<Test> selectUserList() throws Exception;
	
	public int insertUser(Test test);
}
