package cn.com.demo.javaweb.tp10.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTag extends BodyTagSupport {
    private int begin = 1;
    
	@Override
	public int doStartTag() throws JspException {
		return BodyTagSupport.EVAL_BODY_BUFFERED;//.EVAL_BODY_INCLUDE;//super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("Hello world");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	@Override
	public int doAfterBody() throws JspException {
//		// 输出body的内容
//		JspWriter out = this.getPreviousOut();
//		try {
//			out.println(this.getBodyContent().getString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return BodyTagSupport.SKIP_BODY;//super.doAfterBody();
		
		int result = BodyTagSupport.EVAL_BODY_AGAIN;
		
		//JspWriter out = this.pageContext.getOut();
		JspWriter out = this.getPreviousOut();
		BodyContent bd = null;
		try {
			bd = this.getBodyContent();
			bd.append("->"+begin+++"<br/>");
//			out.println(bd.getString() + "->");
//			out.println(begin+++"<br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(begin>=21) {
			try {
				out.println(bd.getString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result = BodyTagSupport.SKIP_BODY;
		}
		
		return result;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

}
