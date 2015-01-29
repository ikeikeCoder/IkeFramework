package org.fervorseed.ikeframework.initializer.config.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* @package org.fervorseed.ikeframework.config.common
* @fileName BusinessConfig.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description : service 컴포넌트를 스캔한다.  
*/
@Configuration
@EnableAsync
@EnableTransactionManagement
@ComponentScan("org.fervorseed.ikeframework.service")
public class BusinessConfig {
	
	@Autowired
	DataSource dataSource;

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
	
}
