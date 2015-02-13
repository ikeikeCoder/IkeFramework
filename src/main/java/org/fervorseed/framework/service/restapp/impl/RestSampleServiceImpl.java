package org.fervorseed.framework.service.restapp.impl;

import java.util.List;

import org.fervorseed.framework.domain.restapp.RestSample;
import org.fervorseed.framework.mapper.restapp.RestSampleMapper;
import org.fervorseed.framework.service.restapp.RestSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestSampleServiceImpl implements RestSampleService{
	
	@Autowired
	RestSampleMapper restSampleMapper;

	@Override
	public List<RestSample> selectUserList() throws Exception{
		
		return restSampleMapper.selectUserList();
	}

	@Override
	public int insertUser(RestSample restSample) {
		return restSampleMapper.insertUser(restSample);
	}

	@Override
	public int deleteUser(String id) {
		return restSampleMapper.deleteUser(id);
	}

}
