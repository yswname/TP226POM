package cn.com.demo.javaweb.tp11.xml;

public class Student {
    private String code;
    private String aliaName;
    private String name;
    private String sex;
    private int age;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAliaName() {
		return aliaName;
	}
	public void setAliaName(String aliaName) {
		this.aliaName = aliaName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [code=" + code + ", aliaName=" + aliaName + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ "]";
	}
	
	
}
