package com.chao.book;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.chao.book")
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class BookApplication {
	
	//前台和后台的session
	private static String FRONT_SESSION_NAME ="frontUserSession";
	//后台
	private static String ADMIN_SESSION_NAME ="adminUserSession";

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	
	/**
	 * 配置拦截器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean registrFilter(){
		FilterRegistrationBean regist = new FilterRegistrationBean();
		regist.setFilter(new Filter() {
			
			@Override
			public void init(FilterConfig arg0) throws ServletException {
				
			}
			
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain fitlerChain)
					throws IOException, ServletException {
				System.out.println("进入拦截器。。。");
				//得到httpservletrequest
				HttpServletRequest hrequest = (HttpServletRequest) request;
				HttpServletResponse hresponse = (HttpServletResponse) response;
				
				//获取请求的url
				String uri = hrequest.getRequestURI();
				//获取从哪个页面过来的链接；
				String referer = hrequest.getHeader("referer");
				Integer memerSession = null;
				try{
					if(uri.contains("api")){
						memerSession = (Integer)hrequest.getSession().getAttribute(FRONT_SESSION_NAME);
						System.out.println("当前登录着为：=====" + memerSession);
					}else if(uri.contains("sys")){
						memerSession = (Integer)hrequest.getSession().getAttribute(ADMIN_SESSION_NAME);
						System.out.println("当前登录者为： ========= " + memerSession);
					}
					String source = hrequest.getParameter("source");
					//获取项目根路径
					String path = hrequest.getContextPath();
					//判断是否登录，如未登录跳转相应的登录页面
					if(memerSession != null){
						if(uri.contains("wx")){
							//判断是不是微信登录
						}
						fitlerChain.doFilter(request, response);
						return;
					}else{
						System.out.println("source 的值为：" + source);
						if(uri.contains("api")){
							if(source == null || source.equals("")){
								hresponse.sendRedirect(path + "/api/login");
							}else{
								hresponse.sendRedirect(path + "/wx/login ? source =" + source );
							}
						}else if(uri.contains("sys")){
							if(source == null || source.equals("")){
								hresponse.sendRedirect(path + "/sys/login");
							}else{
								hresponse.sendRedirect(path + "/wx/login ? source =" + source );
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void destroy() {
				
			}
		});
		regist.addUrlPatterns("api");
		regist.setOrder(1);
		regist.addUrlPatterns("sys");
		regist.setOrder(2);
		return regist;
	}
	
	
	//配置hibernatejpa的sessionFactory工厂
	@Bean
	public HibernateJpaSessionFactoryBean hibernateJpa(){
		return new  HibernateJpaSessionFactoryBean();
	}
}
