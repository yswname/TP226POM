package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class TestDocumentBuilder {

	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		InputStream in = TestDocumentBuilder.class.getClassLoader().getResourceAsStream("classes.xml");
		Document doc = builder.parse(in);
		System.out.println("ok");
	}

}
