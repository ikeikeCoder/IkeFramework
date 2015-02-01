package org.fervorseed.ikeframework.service.web.impl;

import java.util.List;

import org.fervorseed.ikeframework.domain.web.Test;
import org.fervorseed.ikeframework.mapper.web.TestMapper;
import org.fervorseed.ikeframework.service.web.TestService;
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
