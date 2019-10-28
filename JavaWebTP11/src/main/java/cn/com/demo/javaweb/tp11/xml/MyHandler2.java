package cn.com.demo.javaweb.tp11.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler2 extends DefaultHandler {
	private List<Student> stuList;
	private Student stu;
	private boolean isName,isSex,isAge;

	public List<Student> getStuList() {
		return stuList;
	}

	@Override
	public void startDocument() throws SAXException {
		this.stuList = new ArrayList<Student>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName) {
		case "stu":
			this.stu = new Student();
			this.stuList.add(stu);
			
			this.stu.setCode(attributes.getValue("code"));
			this.stu.setAliaName(attributes.getValue("aliaName"));
			break;
		case "name":
			this.isName = true;
			break;
		case "sex":
			this.isSex = true;
			break;
		case "age":
			this.isAge = true;
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case "name":
			this.isName = false;
			break;
		case "sex":
			this.isSex = false;
			break;
		case "age":
			this.isAge = false;
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String text = new String(ch,start,length);
		if(this.isName) {
			this.stu.setName(text);
		}else if(this.isSex) {
			this.stu.setSex(text);
		}else if(this.isAge) {
			this.stu.setAge(Integer.parseInt(text));
		}
	}

}
