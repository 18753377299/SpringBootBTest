package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.common.filter.SecondFilter;
import com.example.common.listener.SecondListener;
import com.example.common.servlet.SecondServlet;

@SpringBootApplication
//(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example")
@ComponentScan(basePackages="com.example")
/*在 springBoot 启动时会扫描@WebServlet，并将该类实例化*/
@ServletComponentScan(basePackages="com.example.common")
/*缓存配置*/
@EnableCaching
/*开启定时任务*/
@EnableScheduling
@EnableAutoConfiguration
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}
	
	
	//第二种整合servlet的方式
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	/**
	* 注册 Filter
	*/
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		//bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}
	/**
	* 注册 listener
	*/
	@Bean
	public ServletListenerRegistrationBean<SecondListener>
			getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SecondListener> bean= new
		ServletListenerRegistrationBean<SecondListener>(new SecondListener());
		return bean;
	}

}
