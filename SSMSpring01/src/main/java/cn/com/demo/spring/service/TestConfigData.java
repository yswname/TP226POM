package cn.com.demo.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestConfigData {
	private String testStr;
	private int testInt;
	private double testDouble;
	private List testList;
	private Set testSet;
	private Map testMap;
	private Properties testProp;

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public int getTestInt() {
		return testInt;
	}

	public void setTestInt(int testInt) {
		this.testInt = testInt;
	}

	public double getTestDouble() {
		return testDouble;
	}

	public void setTestDouble(double testDouble) {
		this.testDouble = testDouble;
	}

	public List getTestList() {
		return testList;
	}

	public void setTestList(List testList) {
		this.testList = testList;
	}

	public Set getTestSet() {
		return testSet;
	}

	public void setTestSet(Set testSet) {
		this.testSet = testSet;
	}

	public Map getTestMap() {
		return testMap;
	}

	public void setTestMap(Map testMap) {
		this.testMap = testMap;
	}

	public Properties getTestProp() {
		return testProp;
	}

	public void setTestProp(Properties testProp) {
		this.testProp = testProp;
	}

	@Override
	public String toString() {
		return "TestConfigData [testStr=" + testStr + ", testInt=" + testInt + ", testDouble=" + testDouble
				+ ", testList=" + testList + ", testSet=" + testSet + ", testMap=" + testMap + ", testProp=" + testProp
				+ "]";
	}

}
