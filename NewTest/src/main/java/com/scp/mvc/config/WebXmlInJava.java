package com.scp.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlInJava implements WebApplicationInitializer {
 
	static{
		System.out.println("inside webxml config..");
	}
	
    public void onStartup(ServletContext container) throws ServletException {
    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringBeanXmlInJava.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("springmvc", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
