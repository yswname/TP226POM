package cn.com.demo.javaweb.tp11.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class TestDocumentBuilder {

	public static void main(String[] args) throws Exception{
		// 创建BuilderFactory对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 设置解析器解析的时候，需要验证xml的有效性
		factory.setValidating(true);
		// 用工厂对象产生builder解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 读取资源流
		InputStream in = TestDocumentBuilder.class.getClassLoader().getResourceAsStream("classes.xml");
		// 使用builder解析器解析资源（xml），返回Document对象（DOM模型）
		Document doc = builder.parse(in);
		System.out.println("ok");
		// doc中的数据
		
		// 获取所有班级
		NodeList clsElementList = doc.getElementsByTagName("class");
		// 循环每个班级
		for(int i=0;i<clsElementList.getLength(); i++) {
			// 班级
			Element clsElement = (Element)clsElementList.item(i);
			// 获取班级的id
			String clsId = clsElement.getAttribute("id");
			System.out.println(clsId);
			
			// 获取班级中的学生
			NodeList stuList = clsElement.getChildNodes(); //clsElement.getElementsByTagName("stu")
			//System.out.println(stuList.getLength());
			for(int j=0;j<stuList.getLength();j++) {
				Node chidNode = stuList.item(j);
				if(chidNode.getNodeType() == Node.ELEMENT_NODE) {
					Element stu = (Element)chidNode;
					String code = stu.getAttribute("code");
					String aliaName = stu.getAttribute("aliaName");
					
					Element nameElement = (Element)stu.getFirstChild().getNextSibling();
					String name = nameElement.getFirstChild().getNodeValue();
					
					Element sexElement = (Element)stu.getElementsByTagName("sex").item(0);
					String sex = sexElement.getTextContent();
					
					Element ageElement = (Element)stu.getLastChild().getPreviousSibling();
					String age = ((Text)ageElement.getFirstChild()).getWholeText();
					
					System.out.println("   " + code +"," + aliaName + "," + name + "," + sex+"," + age);
				}
			}
		}
	}

}
