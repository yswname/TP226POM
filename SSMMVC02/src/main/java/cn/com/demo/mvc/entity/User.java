package cn.com.demo.mvc.entity;

public class User {
    private int urId;
    private String urUserName;
    private String sex;
	public int getUrId() {
		return urId;
	}
	public void setUrId(int urId) {
		this.urId = urId;
	}
	public String getUrUserName() {
		return urUserName;
	}
	public void setUrUserName(String urUserName) {
		this.urUserName = urUserName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [urId=" + urId + ", urUserName=" + urUserName + ", sex=" + sex + "]";
	}

}
