package cn.com.demo.javaweb.tp11.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	private boolean isName,isSex,isAge;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("class")) {
			String clsId = attributes.getValue("id");
			System.out.println(clsId);
		}else if(qName.equals("stu")) {
			String code = attributes.getValue("code");
			String aliaName = attributes.getValue("aliaName");
			System.out.print("   " + code +","+aliaName) ;
		}else if(qName.equals("name")) {
			this.isName = true;
		}else if(qName.equals("sex")) {
			this.isSex = true;
		}else if(qName.equals("age")) {
			this.isAge = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("stu")) {
			System.out.println();
		}else if(qName.equals("name")) {
			this.isName = false;
		}else if(qName.equals("sex")) {
			this.isSex = false;
		}else if(qName.equals("age")) {
			this.isAge = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String text = new String(ch, start,length);
		if(isName) {
			System.out.print(","+text);
		}else if(isSex) {
			System.out.print("," + text);
		}else if(isAge) {
			System.out.print("," + text);
		}
	}

}
