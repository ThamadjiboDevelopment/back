package com.concreteitsolutions.framework.api;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Starting web Application...");

		AnnotationConfigWebApplicationContext containerContext = new AnnotationConfigWebApplicationContext();

		containerContext.register(AppConfig.class);

		servletContext.addListener(new ContextLoaderListener(containerContext));

		ServletRegistration.Dynamic dispatcher =
				servletContext.addServlet("dispatcher", new DispatcherServlet(containerContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");

	}
}
