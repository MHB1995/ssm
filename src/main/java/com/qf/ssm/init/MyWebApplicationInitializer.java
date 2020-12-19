package com.qf.ssm.init;

import com.qf.ssm.config.MainConfig;
import com.qf.ssm.config.SpringMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


//启动tomcat后执行这个类
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //帮加载父子容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        //加载sm配置文件
        context.register(MainConfig.class);
        //加载springmvc配置文件
        context.register(SpringMvcConfig.class);


        //加一个编码过滤，使用utf-8
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");


        //放入tomcat
        FilterRegistration.Dynamic characterEncodingFilter1 = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);

        //设置拦截器的路径是/*
        characterEncodingFilter1.addMappingForUrlPatterns(null,true,"/*");

        //中央控制器
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
