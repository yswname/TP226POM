package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TestDom4j {

	public static void main(String[] args) throws Exception {
		write();
	}
	
	public static void write()throws Exception{
		List<Student> stuList = new ArrayList<Student>();
		for(int i=0;i<10;i++) {
			Student stu = new Student();
			stu.setAge(10+i);
			stu.setAliaName("alia"+i);
			stu.setCode("code"+i);
			stu.setName("name" +i);
			stu.setSex("女"+i);
			stuList.add(stu);
		}
		
		// 创建并且拼凑出document
		Document doc = DocumentHelper.createDocument();
		// 创建并且添加根元素（班级）
		Element clsElement = doc.addElement("班级");
		for(Student stu:stuList) {
			Element stuElement = clsElement.addElement("学生");
			// 添加学生属性（code aliaName）
			stuElement.addAttribute("code", stu.getCode());
			stuElement.addAttribute("aliaName", stu.getAliaName());
			
			// 添加学生的name sex 和 age字元素
//			stuElement.addElement("name", stu.getName());
//			stuElement.addElement("sex", stu.getSex());
//			stuElement.addElement("age", String.valueOf(stu.getAge()));
			Element nameElement = stuElement.addElement("name");
			nameElement.addText(stu.getName());
			Element sexElement = stuElement.addElement("sex");
			sexElement.setText(stu.getSex());
			stuElement.addElement("age").addText(String.valueOf(stu.getAge()));
		}
		// 写doc到控制台
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(System.out, format);
		
		writer.write(doc);
		writer.close();
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
