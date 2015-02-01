	package org.fervorseed.ikeframework.initializer.config;

import org.fervorseed.ikeframework.initializer.config.common.BusinessConfig;
import org.fervorseed.ikeframework.initializer.config.common.DataAccessConfig;
import org.fervorseed.ikeframework.initializer.config.common.DataSourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


/**
* @package org.fervorseed.ikeframework.common.config
* @fileName RootConfig.java
* 
* @Company : FervorSeed
* @Author  : SIM
* @Date    : 2015. 1. 21. 오전 9:52:50
* @Version : 1.0
* @Description : MVC 설정용 클래스.
* 						이 클래스는 스프링의 servlet-context.xml 역활을 대신함
*/

@Configuration
@ComponentScan(basePackages = {
		"org.fervorseed.ikeframework.aop"
})
@Import(value = {BusinessConfig.class, DataSourceConfig.class, DataAccessConfig.class})
public class RootConfig {
	
}
