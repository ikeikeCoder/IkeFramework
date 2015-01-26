package org.fervorseed.ikeframework.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
* @package org.fervorseed.ikeframework.config.mvc
* @fileName ApiMvcConfig.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description :RestMVC 설정용 클래스.
* 						이 클래스는 스프링의 servlet-context.xml 역활을 대신함 
* 						{@EnableWebMvc} 설정 파일
* 						{@EnableWebMvc} 은 xml 설정에서 <mvc:annotation-driven /> 의 역활이다
*/
@Configuration
@EnableWebMvc
@ComponentScan("")
public class ApiMvcConfig {
	
	private static final int CACHE_PERIOD = 31556926; // one year

}
