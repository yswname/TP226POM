package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestSAXParser {
    //List<Student>
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		// 读取资源流
		InputStream in = TestDocumentBuilder.class.getClassLoader().getResourceAsStream("classes.xml");
		//parser.parse(in, new MyHandler());
		
		MyHandler2 handler = new MyHandler2();
		parser.parse(in, handler);
		
		List<Student> stuList = handler.getStuList();
		for(Student stu:stuList) {
			System.out.println(stu);
		}
	}

}
