package org.fervorseed.ikeframework.mapper.web;

import org.fervorseed.ikeframework.domain.web.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
	public Test getCabinetInfo();
}
