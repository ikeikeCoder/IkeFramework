package org.fervorseed.framework.mapper.restapp;

import java.util.List;

import org.fervorseed.framework.domain.restapp.RestSample;
import org.springframework.stereotype.Repository;

@Repository
public interface RestSampleMapper {
	public List<RestSample> selectUserList();
	
	public int insertUser(RestSample restSample);
	
	public int deleteUser(String id);
}
