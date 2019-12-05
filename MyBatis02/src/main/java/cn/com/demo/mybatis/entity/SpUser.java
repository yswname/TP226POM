package cn.com.demo.mybatis.entity;

public class SpUser {
    private int urId;
    private String urUserName;
    private String urPassword;
    
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
	public String getUrPassword() {
		return urPassword;
	}
	public void setUrPassword(String urPassword) {
		this.urPassword = urPassword;
	}
	@Override
	public String toString() {
		return "SpUser [urId=" + urId + ", urUserName=" + urUserName + ", urPassword=" + urPassword + "]";
	}
}
