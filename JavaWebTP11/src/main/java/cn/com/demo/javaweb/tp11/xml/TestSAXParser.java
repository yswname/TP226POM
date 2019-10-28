package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class TestSAXParser {
    //List<Student>
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		// 读取资源流
		InputStream in = TestDocumentBuilder.class.getClassLoader().getResourceAsStream("classes.xml");
		parser.parse(in, new MyHandler());
	}

}
