package org.fervorseed.framework.service.webapp.impl;

import java.util.List;

import org.fervorseed.framework.domain.webapp.Test;
import org.fervorseed.framework.mapper.webapp.TestMapper;
import org.fervorseed.framework.service.webapp.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestMapper testMapper;

	@Override
	public List<Test> selectUserList() throws Exception{
		
		return testMapper.selectUserList();
	}

	@Override
	public int insertUser(Test test) {
		testMapper.insertUser(test);
		return testMapper.insertUser(test);
	}

}
