package org.fervorseed.framework.initializer.config.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* @package org.fervorseed.framework.initializer.config.common
* @fileName BusinessConfig.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description : {@Repository} 컴포넌트를 스캔한다.  
*/
@Configuration
@EnableTransactionManagement()	// 트랜젝션 사용
@EnableAspectJAutoProxy
@ImportResource(value = "classpath:/config/transaction/transaction_config.xml")		// AOP 방식 선언적 트랜젝선 설정
@ComponentScan(basePackages = {"org.fervorseed.framework.service"}, useDefaultFilters = false, includeFilters = {@Filter(Service.class)})
public class BusinessConfig {
	
	@Autowired
	DataSource dataSource;

	/**
	 * TransactionManagement {@link org.springframework.transaction.PlatformTransactionManager} 설정
	 * */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
