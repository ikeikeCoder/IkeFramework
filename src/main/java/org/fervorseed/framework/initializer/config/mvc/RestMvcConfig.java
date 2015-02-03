package org.fervorseed.framework.initializer.config.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
* @package org.fervorseed.framework.initializer.config.mvc
* @fileName RestMvcConfig.java
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
@ComponentScan(basePackages = {"org.fervorseed.framework.controller.restapp"}, 
						  useDefaultFilters=false, 
						  includeFilters={@Filter(Controller.class)}
						)
public class RestMvcConfig extends WebMvcConfigurerAdapter {
	
	private static final int CACHE_PERIOD = 31556926; // one year
	
	/**
	 * HttpMessageConverter 설정.
	 * */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(getJsonMessageConverter());
	}
	
	/**
	 * JsonMessageConverter
	 * */
	@Bean
	public MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		
		List<MediaType> list = new ArrayList<MediaType>();
		
		list.add(MediaType.APPLICATION_JSON);
		
		jsonMessageConverter.setPrettyPrint(true);
		jsonMessageConverter.setSupportedMediaTypes(list);
		return jsonMessageConverter;
	}

	/**
	 * resource 파일 경로 설정 (css, javascript 등등)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		  .addResourceLocations("/resources/", "classpath:/resources/")
		  .setCachePeriod(CACHE_PERIOD);	// 브라우저 캐시 만료 기간 1년 설정.
	}
	
	/**
     * <mvc:default-servlet-handler/>
     * 기본서블릿 사용 선언
     */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * {@link org.springframework.web.multipart.MultipartResolver} 설정
	 * 파일 업로드 설정
	 * */
	@Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
	

}
