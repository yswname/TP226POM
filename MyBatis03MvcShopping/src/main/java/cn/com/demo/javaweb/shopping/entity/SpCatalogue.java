package cn.com.demo.javaweb.shopping.entity;

public class SpCatalogue {
    private int ctId;
    private String ctName;
    private String ctRemark;
    private Integer ctParentId;
    
	public Integer getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtRemark() {
		return ctRemark;
	}
	public void setCtRemark(String ctRemark) {
		this.ctRemark = ctRemark;
	}
	public Integer getCtParentId() {
		return ctParentId;
	}
	public void setCtParentId(Integer ctParentId) {
		this.ctParentId = ctParentId;
	}
    
    
}
