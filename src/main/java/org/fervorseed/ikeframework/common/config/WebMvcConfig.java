package org.fervorseed.ikeframework.common.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* @package org.fervorseed.ikeframework.common.config
* @fileName WebMvcConfig.java
* 
* @Company : FervorSeed
* @Author  : SIM
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description : \@EnableWebMvc 설정 파일
* 						\@EnableWebMvc 은 xml 설정에서 <mvc:annotation-driven /> 의 역활이다
*/
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	/**
	 * HttpMessageConverter 설정.
	 * */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonMessageConverter());
		converters.add(xmlMessageConverter());
	}
	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		return jsonMessageConverter;
	}
	
	@Bean MappingJackson2HttpMessageConverter xmlMessageConverter() {
		MappingJackson2HttpMessageConverter xmlMessageConverter = new MappingJackson2HttpMessageConverter();
		return xmlMessageConverter;
	}

	/**
	 * resource 파일 경로 설정 (css, javascript 등등)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		  .addResourceLocations("/resources/")
		  .addResourceLocations("classpath:/resources/");
	}
}
