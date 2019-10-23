package cn.com.demo.javaweb.tp10.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	private String color;
	private int age;
	private Date date;

	@Override
	public int doEndTag() throws JspException {
		int result = super.doEndTag();//TagSupport.SKIP_PAGE;
		
		// 输出红色的hello world
		JspWriter out = this.pageContext.getOut();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			out.print("<font color='"+color+"'>Hello"+format.format(date)+" World "+(++age)+"</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
