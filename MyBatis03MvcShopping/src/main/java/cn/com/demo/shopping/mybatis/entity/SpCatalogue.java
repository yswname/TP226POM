package cn.com.demo.shopping.mybatis.entity;

import java.io.Serializable;

public class SpCatalogue extends cn.com.demo.javaweb.shopping.entity.SpCatalogue implements Serializable {
    private Integer ctId;

    private String ctName;

    private Integer ctParentId;

    private String ctRemark;

    private static final long serialVersionUID = 1L;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
        super.setCtId(ctId);
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName == null ? null : ctName.trim();
    }

    public Integer getCtParentId() {
        return ctParentId;
    }

    public void setCtParentId(Integer ctParentId) {
        this.ctParentId = ctParentId;
        super.setCtParentId(ctParentId);
    }

    public String getCtRemark() {
        return ctRemark;
    }

    public void setCtRemark(String ctRemark) {
        this.ctRemark = ctRemark == null ? null : ctRemark.trim();
    }
}