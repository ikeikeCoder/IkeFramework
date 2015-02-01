package org.fervorseed.framework.initializer.config.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* @package org.fervorseed.framework.config.common
* @fileName BusinessConfig.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description : service 컴포넌트를 스캔한다.  
*/
@Configuration
@EnableTransactionManagement()
@EnableAspectJAutoProxy
@ImportResource(value = "classpath:/config/transaction/transaction_config.xml")
@ComponentScan("org.fervorseed.framework.service")
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
