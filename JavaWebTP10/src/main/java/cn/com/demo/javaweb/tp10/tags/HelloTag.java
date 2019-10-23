package cn.com.demo.javaweb.tp10.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		int result = super.doEndTag();
		
		// 输出红色的hello world
		JspWriter out = this.pageContext.getOut();
		try {
			out.print("<font color='red'>Hello World</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
