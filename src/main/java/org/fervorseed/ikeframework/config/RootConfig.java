	package org.fervorseed.ikeframework.config;

import org.fervorseed.ikeframework.config.web.WebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


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
@EnableAsync // @Async 어노테이션을 사용하기 위함
@Import({WebMvcConfig.class})	// @EnableWebMvc 설정 파일
public class RootConfig {
	
}
