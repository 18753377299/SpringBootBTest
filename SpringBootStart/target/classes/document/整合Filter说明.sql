一，整合 Servlet
1 ， 通过注解扫描完成 Servlet  组件的注册
1.1  编写 servlet
/**
*SpringBoot 整合 Servlet 方式一
*
*<servlet>
* <servlet-name>FirstServlet</servlet-name>
* <servlet-class>com.bjsxt.servlet.FirstServlet</servlet-class>
*</servlet>
*
*<servlet-mapping>
* <servlet-name>FirstServlet</servlet-name>
* <url-pattern>/first</url-pattern>
*</servlet-mapping>
*
*/
@WebServlet(name="FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
// TODO Auto-generated method stub
super.doGet(req, resp);
}
}
---并且在启动类中添加 @ServletComponentScan 即可整合成功、
2、 通过方法完成 Servlet 组件的注册


第一种整合Filter方式： 
---在filter中添加注解@WebFilter(filterName="FirstFilter",urlPatterns="/*")
---并且在启动类中添加 @ServletComponentScan 即可整合成功

第二种整合filter方式：
在启动类中添加一下方法：
	/**
	 * 注册Filter,注册servlet的方法和这个一样
	 * */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(
				new FirstFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}

第一种整合Listener方式： 
启动程序的时候进行监听，在启动类中的监听优先于注解的监听
--@WebListener
--public class FirstListener implements ServletContextListener 
---并且在启动类中添加 @ServletComponentScan 即可整合成功

第二种整合Listener方式：
---在启动类中添加一下方法：
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


CREATE TABLE
    users
    (
        id VARCHAR(32) NOT NULL,
        age VARCHAR(20) NOT NULL,
        name VARCHAR(20) NOT NULL,
       
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

#四、访问静态资源： 寻找静态资源的目录
1. SpringBoot 从 从 classpath/static  的目录
注意目录名称必须是 static
2. 2. ServletContext 
在 src/main/webapp 目录名称必须要 webapp

访问的请求如下： http://localhost:8012/java.PNG



