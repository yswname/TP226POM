package cn.com.demo.mybatis.entity;

import java.util.List;

public class SpUser {
    private int urId;
    private String urUserName;
    private String urPassword;
    
    private SpIdCard idCard;
    private List<SpOrder> orders;
    
    
	public List<SpOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<SpOrder> orders) {
		this.orders = orders;
	}
	public SpIdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(SpIdCard idCard) {
		this.idCard = idCard;
	}
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
