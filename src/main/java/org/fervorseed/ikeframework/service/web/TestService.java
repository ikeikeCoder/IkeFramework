package org.fervorseed.ikeframework.service.web;

import java.util.List;

import org.fervorseed.ikeframework.domain.web.Test;

public interface TestService {
	public List<Test> selectUserList() throws Exception;
	
	public int insertUser(Test test);
}
