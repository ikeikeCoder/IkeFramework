package org.fervorseed.ikeframework.config.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
@ComponentScan("org.fervorseed.ikeframework.service")
public class BusinessConfig {

}
