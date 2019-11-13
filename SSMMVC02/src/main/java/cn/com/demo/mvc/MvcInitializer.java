package cn.com.demo.mvc;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.com.demo.mvc.config.SpringMVCConfig;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private WebApplicationInitializer initializer;
    private SpringServletContainerInitializer t;
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
