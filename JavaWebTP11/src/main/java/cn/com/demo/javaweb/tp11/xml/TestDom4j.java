package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom4j {

	public static void main(String[] args) throws Exception {
		read();
	}

	public static void read() throws Exception {
		// 创建Dom4j的Reader
		SAXReader reader = new SAXReader();
		// 读取资源流
		InputStream in = TestDocumentBuilder.class.getClassLoader().getResourceAsStream("classes.xml");
		// 解析
		Document doc = reader.read(in);
		
		// 获取所有学生的姓名
		String xPath = "/classes/class/stu/name";
		List<Element> eleList = doc.selectNodes(xPath);
		for(Element ele:eleList) {
			String nameValue = ele.getTextTrim();
			System.out.println(nameValue);
		}
		xPath = "/classes/class/stu/@code";
		List<Attribute> attrList =  doc.selectNodes(xPath);
		for(Attribute attr:attrList) {
			String attrValue = attr.getValue();
			System.out.println(attrValue);
		}
		
		xPath = "/classes/class/stu[name=\"zhangsan11\"]/@code";
		attrList =  doc.selectNodes(xPath);
		for(Attribute attr:attrList) {
			String attrValue = attr.getValue();
			System.out.println(attrValue);
		}
		
		xPath = "/classes/class/stu[@code=\"1002\"]/age";
		eleList = doc.selectNodes(xPath);
		for(Element ele:eleList) {
			String nameValue = ele.getTextTrim();
			System.out.println(nameValue);
		}
		
		xPath = "/classes/class/stu[@code='2001']/name/@test";
		attrList =  doc.selectNodes(xPath);
		for(Attribute attr:attrList) {
			String attrValue = attr.getValue();
			System.out.println(attrValue);
		}
		
		xPath = "/classes/class/stu[@code='1001']/@aliaName";
		attrList =  doc.selectNodes(xPath);
		for(Attribute attr:attrList) {
			String attrValue = attr.getValue();
			System.out.println(attrValue);
		}
	}

}
