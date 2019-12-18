package cn.com.ssm.shopping;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.com.ssm.shopping.config.SpringConfig;
import cn.com.ssm.shopping.config.SpringMVCConfig;

public class ShoppingInitailizer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"*.mvc"};
	}

}
