	package org.fervorseed.framework.initializer.config;

import org.fervorseed.framework.initializer.config.common.BusinessConfig;
import org.fervorseed.framework.initializer.config.common.DataAccessConfig;
import org.fervorseed.framework.initializer.config.common.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


/**
* @package org.fervorseed.framework.common.config
* @fileName RootConfig.java
* 
* @Company : FervorSeed
* @Author  : Ike
* @Date    : 2015. 1. 21. 오전 9:52:50
* @Version : 1.0
* @Description : MVC 설정용 클래스.
* 						이 클래스는 스프링의 servlet-context.xml 역활을 대신함
*/

@Configuration
@ComponentScan(basePackages = {
		"org.fervorseed.framework.common.aop"		// aop 컴퍼넌트 조회
})
/* 각종 설정 파일 로딩 
 * - BusinessConfig = SERVICE 설정 파일
 * - DataSourceConfig = BoneCP(JDBC) 설정파일
 * - DataAccessConfig = Mapper(DAO) 설정 파일 
 * */
@Import(value = {BusinessConfig.class, DataSourceConfig.class, DataAccessConfig.class})
public class RootConfig {
	
}
