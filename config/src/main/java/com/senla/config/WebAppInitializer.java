package com.senla.config;

import com.senla.filter.AuthFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext container){
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class, WebConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new AuthFilter()};
    }
}

