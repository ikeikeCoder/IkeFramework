package org.fervorseed.framework.initializer;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.fervorseed.framework.common.filter.SitemeshFilter;
import org.fervorseed.framework.initializer.config.RootConfig;
import org.fervorseed.framework.initializer.config.mvc.RestMvcConfig;
import org.fervorseed.framework.initializer.config.mvc.WebMvcConfig;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;


/**
* @package org.fervorseed.framework.initializer
* @fileName Initializer.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 21. 오전 9:41:27
* @Version : 1.0
* @Description : WebApplicationInitializer 를 상속하면, 서블릿 컨테이너가 실행될 때 onStartup() 메소드가 자동으로 호출된다.
* 						이 클래스는 web.xml 의 역할을 대신하거나 보충한다.
*/
public class Initializer implements WebApplicationInitializer {
	
	private static final String ENCODING = "UTF-8";
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5MB
	
	/*  web 설정 시작위치 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		this.addDispatcherServlet(servletContext, WebMvcConfig.class ,"webDispatcher", "/web/*", "true", 1);		// web 서블릿 생성
		this.addDispatcherServlet(servletContext, RestMvcConfig.class ,"restDispatcher", "/rest/*", "true", 2);		// restFul 서블릿 생성
        this.addUtf8CharacterEncodingFilter(servletContext, "/*");
        this.addHiddenHttpMethodFilter(servletContext, "/*");
        this.addSiteMeshFilter(servletContext, "/*");
	}
	
	/**
     * Dispatcher Servlet 을 추가한다.
     * CORS 를 가능하게 하기 위해서 dispatchOptionsRequest 설정을 true 로 한다.
     * @param servletContext, servletName, pattern, cors, order
     */
	private void addDispatcherServlet (ServletContext servletContext, Class servletConfig, String servletName, String pattern, String cors, int order) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(servletConfig);
		
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(servletName, new DispatcherServlet(applicationContext));
        dispatcher.setLoadOnStartup(order);
        dispatcher.addMapping(pattern);
        dispatcher.setInitParameter("dispatchOptionsRequest", cors); // CORS 를 위해서 option request 도 받아들인다.
        dispatcher.setMultipartConfig(new MultipartConfigElement("",maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2));
	}
	
	/**
     * UTF-8 캐릭터 인코딩 필터.
     * @param servletContext, pattern
     */
    private void addUtf8CharacterEncodingFilter(ServletContext servletContext, String pattern)
    {
        FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", ENCODING);
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, pattern);
    }
    
    /**
     * 스프링 restFul 필터.
     * @param servletContext, pattern
     */
    private void addHiddenHttpMethodFilter(ServletContext servletContext, String pattern) {
        FilterRegistration.Dynamic hiddenHttpMethod = servletContext.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
        hiddenHttpMethod.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, pattern);
    }
    
    /**
     * Sitemesh 필터.
     * @param servletContext, pattern
     */
    private void addSiteMeshFilter(ServletContext servletContext, String pattern) {
    	FilterRegistration.Dynamic filter = servletContext.addFilter("sitemesh", SitemeshFilter.class);
    	filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, pattern);
    }
}
