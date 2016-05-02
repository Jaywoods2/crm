package cn.zk.entity;

import java.io.Serializable;

public class Sys_role implements Serializable {
	private int role_id;
	private String role_name;
	private String role_desc;
	private int role_flag;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String roleDesc) {
		role_desc = roleDesc;
	}

	public int getRole_flag() {
		return role_flag;
	}

	public void setRole_flag(int roleFlag) {
		role_flag = roleFlag;
	}

}
