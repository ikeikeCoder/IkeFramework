package org.fervorseed.ikeframework.mapper.web;

import java.util.List;

import org.fervorseed.ikeframework.domain.web.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
	public List<Test> selectUserList();
	
	public int insertUser(Test test);
}
