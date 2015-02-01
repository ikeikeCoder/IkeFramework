package org.fervorseed.framework.mapper.webapp;

import java.util.List;

import org.fervorseed.framework.domain.webapp.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
	public List<Test> selectUserList();
	
	public int insertUser(Test test);
}
