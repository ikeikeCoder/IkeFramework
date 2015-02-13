package org.fervorseed.framework.service.restapp;

import java.util.List;

import org.fervorseed.framework.domain.restapp.RestSample;

public interface RestSampleService {
	public List<RestSample> selectUserList() throws Exception;
	
	public int insertUser(RestSample restSample);
	
	public int deleteUser(String id);
}
