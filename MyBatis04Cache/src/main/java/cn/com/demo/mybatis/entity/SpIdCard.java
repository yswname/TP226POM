package cn.com.demo.mybatis.entity;

public class SpIdCard {
    private int icId;
    private String icCode;
    private String icName;
    
    private SpUser user;
    
    
	public SpUser getUser() {
		return user;
	}
	public void setUser(SpUser user) {
		this.user = user;
	}
	public int getIcId() {
		return icId;
	}
	public void setIcId(int icId) {
		this.icId = icId;
	}
	public String getIcCode() {
		return icCode;
	}
	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}
	public String getIcName() {
		return icName;
	}
	public void setIcName(String icName) {
		this.icName = icName;
	}
	@Override
	public String toString() {
		return "SpIdCard [icId=" + icId + ", icCode=" + icCode + ", icName=" + icName + "]";
	}
    
    
}
