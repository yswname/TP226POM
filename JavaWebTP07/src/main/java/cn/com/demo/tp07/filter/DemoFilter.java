package cn.com.demo.tp07.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DemoFilter implements Filter {
	private String encoding = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("DemoFilter init...");
		String value = filterConfig.getInitParameter("t");

		String xmlEncoding = filterConfig.getInitParameter("encoding");
		if (xmlEncoding != null && !"".equals(xmlEncoding)) {
			encoding = xmlEncoding;
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("DemoFilter doFilter...");
		// request.setCharacterEncoding(this.encoding);

		// 获取以前的乱码数据
		// ok

		// 转成好码
		// ok

		// 传递给我们的Servlet（设置到请求中 或者 替换请求中以前的的乱码）
		// setAttribute x

		response.setContentType("text/html;charset=" + this.encoding);
		chain.doFilter(new MyRequestWrapper((HttpServletRequest)request), response);// 调用后面的资源
		
		System.out.println("DemoFilter doFilter...end");

		// 响应的过滤逻辑
	}

	@Override
	public void destroy() {
		System.out.println("DemoFilter destory...");
	}

	class MyRequestWrapper extends HttpServletRequestWrapper {

		public MyRequestWrapper(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}

		public String getParameter(String name) {
			// return super.getParameter(name);
			String value = null;
			value = super.getParameter(name);
			if (value != null) {
				try {
					byte[] bytes = value.getBytes("iso-8859-1");
					value = new String(bytes, encoding);
				} catch (Exception e) {
				}
			}
			return value;
		}
	}

}
