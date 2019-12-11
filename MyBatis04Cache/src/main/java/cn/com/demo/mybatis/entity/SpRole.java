package cn.com.demo.mybatis.entity;

import java.util.List;

public class SpRole {
	private int rlId;
	private String rlName;
	private List<SpUser> users;

	public int getRlId() {
		return rlId;
	}

	public void setRlId(int rlId) {
		this.rlId = rlId;
	}

	public String getRlName() {
		return rlName;
	}

	public void setRlName(String rlName) {
		this.rlName = rlName;
	}

	public List<SpUser> getUsers() {
		return users;
	}

	public void setUsers(List<SpUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "SpRole [rlId=" + rlId + ", rlName=" + rlName + ", users=" + users + "]";
	}

}
