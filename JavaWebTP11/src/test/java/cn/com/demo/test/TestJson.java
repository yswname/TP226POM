package cn.com.demo.test;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.tp11.xml.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
//		Student stu =  new Student();
//		stu.setAge(10);
//		stu.setAliaName("别名");
//		stu.setCode("001");
//		stu.setName("姓名");
//		stu.setSex("男");
//		
//		JSONObject jsonObject = JSONObject.fromObject(stu);
//		String jsonString = jsonObject.toString();
//		System.out.println(jsonString);
//		
//		
//		
//		
//		List<Student> stuList = new ArrayList<Student>();
//		stuList.add(stu);
//		
//		stu =  new Student();
//		stu.setAge(12);
//		stu.setAliaName("别名2");
//		stu.setCode("002");
//		stu.setName("姓名2");
//		stu.setSex("男2");
//		stuList.add(stu);
//		
//		JSONArray jsonArray = JSONArray.fromObject(stuList);
//		jsonString = jsonArray.toString();
//		System.out.println(jsonString);
		
		String jsonStr = "{\"code\":\"001\",\"aliaName\":\"别名\",\"sex\":\"男\",\"name\":\"姓名\",\"age\":10}";
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		Student stu = (Student)JSONObject.toBean(jsonObj, Student.class);
		System.out.println(stu);
		
	}

}
