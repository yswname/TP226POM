package cn.com.demo.javaweb.shopping.entity;

import java.util.List;

public class SpProduct {
    private Integer prId;
    private Double prPrice;
    private String prTitle;
    private String prSimpleDesc;
    private String prAttrs;
    private String prDetailDesc;
    private Integer prCtId;
    
    // 图片
    private SpImage listPic;// 列表
    private List<SpImage> smallListPic;// 侧面小图片
    private List<SpImage> bigListPic;// 大图片
    
    
	public SpImage getListPic() {
		return listPic;
	}
	public void setListPic(SpImage listPic) {
		this.listPic = listPic;
	}
	public List<SpImage> getSmallListPic() {
		return smallListPic;
	}
	public void setSmallListPic(List<SpImage> smallListPic) {
		this.smallListPic = smallListPic;
	}
	public List<SpImage> getBigListPic() {
		return bigListPic;
	}
	public void setBigListPic(List<SpImage> bigListPic) {
		this.bigListPic = bigListPic;
	}
	public Integer getPrId() {
		return prId;
	}
	public void setPrId(Integer prId) {
		this.prId = prId;
	}
	public Double getPrPrice() {
		return prPrice;
	}
	public void setPrPrice(Double prPrice) {
		this.prPrice = prPrice;
	}
	public String getPrTitle() {
		return prTitle;
	}
	public void setPrTitle(String prTitle) {
		this.prTitle = prTitle;
	}
	public String getPrSimpleDesc() {
		return prSimpleDesc;
	}
	public void setPrSimpleDesc(String prSimpleDesc) {
		this.prSimpleDesc = prSimpleDesc;
	}
	public String getPrAttrs() {
		return prAttrs;
	}
	public void setPrAttrs(String prAttrs) {
		this.prAttrs = prAttrs;
	}
	public String getPrDetailDesc() {
		return prDetailDesc;
	}
	public void setPrDetailDesc(String prDetailDesc) {
		this.prDetailDesc = prDetailDesc;
	}
	public Integer getPrCtId() {
		return prCtId;
	}
	public void setPrCtId(Integer prCtId) {
		this.prCtId = prCtId;
	}
    
    
}
