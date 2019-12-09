package cn.com.demo.mybatis.entity;

import java.sql.Timestamp;

public class SpOrder {
    private int odId;
    private String odCode;
    private Timestamp odCreateTime;
    private int odUrId;
    private int odAddressId;
    private int odStatus;
    private int odPyId;
	public int getOdId() {
		return odId;
	}
	public void setOdId(int odId) {
		this.odId = odId;
	}
	public String getOdCode() {
		return odCode;
	}
	public void setOdCode(String odCode) {
		this.odCode = odCode;
	}
	public Timestamp getOdCreateTime() {
		return odCreateTime;
	}
	public void setOdCreateTime(Timestamp odCreateTime) {
		this.odCreateTime = odCreateTime;
	}
	public int getOdUrId() {
		return odUrId;
	}
	public void setOdUrId(int odUrId) {
		this.odUrId = odUrId;
	}
	public int getOdAddressId() {
		return odAddressId;
	}
	public void setOdAddressId(int odAddressId) {
		this.odAddressId = odAddressId;
	}
	public int getOdStatus() {
		return odStatus;
	}
	public void setOdStatus(int odStatus) {
		this.odStatus = odStatus;
	}
	public int getOdPyId() {
		return odPyId;
	}
	public void setOdPyId(int odPyId) {
		this.odPyId = odPyId;
	}
	@Override
	public String toString() {
		return "SpOrder [odId=" + odId + ", odCode=" + odCode + ", odCreateTime=" + odCreateTime + ", odUrId=" + odUrId
				+ ", odAddressId=" + odAddressId + ", odStatus=" + odStatus + ", odPyId=" + odPyId + "]";
	}
	
	
}
