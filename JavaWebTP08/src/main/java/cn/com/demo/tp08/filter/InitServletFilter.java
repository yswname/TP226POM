package cn.com.demo.tp08.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import cn.com.demo.tp08.servlet.DemoServlet1;
@WebFilter(filterName="DemoFilter")
public class InitServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("init Filter......");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
