package org.fervorseed.ikeframework.initializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.fervorseed.ikeframework.app.config.AppConfig;
import org.fervorseed.ikeframework.common.config.RootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


/**
* @package org.fervorseed.ikeframework.initializer
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
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		this.addDispatcherServlet(servletContext, "appDispatcher", "/*", "true", 1);
        this.addUtf8CharacterEncodingFilter(servletContext, "/*");
	}
	
	/**
     * Dispatcher Servlet 을 추가한다.
     * CORS 를 가능하게 하기 위해서 dispatchOptionsRequest 설정을 true 로 한다.
     * @param servletContext, servletName, pattern, cors, order
     */
	private void addDispatcherServlet (ServletContext servletContext, String servletName, String pattern, String cors, int order) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
		//applicationContext.getEnvironment().addActiveProfile("production");
		
		 
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(servletName, new DispatcherServlet(applicationContext));
        dispatcher.setLoadOnStartup(order);
        dispatcher.addMapping(pattern);
        dispatcher.setInitParameter("dispatchOptionsRequest", cors); // CORS 를 위해서 option request 도 받아들인다.
	}
	
	/**
     * UTF-8 캐릭터 인코딩 필터를 추가한다.
     * @param servletContext, encoding, pattern
     */
    private void addUtf8CharacterEncodingFilter(ServletContext servletContext, String pattern)
    {
        FilterRegistration.Dynamic filter = servletContext.addFilter("CHARACTER_ENCODING_FILTER", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", ENCODING);
        filter.setInitParameter("forceEncoding", "true");
        filter.addMappingForUrlPatterns(null, false, pattern);
    }
}
