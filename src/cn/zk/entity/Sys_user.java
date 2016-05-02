package cn.zk.entity;

import java.io.Serializable;

public class Sys_user implements Serializable {
	private int usr_id;
	private String usr_name;
	private String usr_password;
	private int usr_role_id;
	private int usr_flag;
	
	public Sys_user() {
	}

	public int getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(int usrId) {
		usr_id = usrId;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usrName) {
		usr_name = usrName;
	}

	public String getUsr_password() {
		return usr_password;
	}

	public void setUsr_password(String usrPassword) {
		usr_password = usrPassword;
	}

	public int getUsr_role_id() {
		return usr_role_id;
	}

	public void setUsr_role_id(int usrRoleId) {
		usr_role_id = usrRoleId;
	}

	public int getUsr_flag() {
		return usr_flag;
	}

	public void setUsr_flag(int usrFlag) {
		usr_flag = usrFlag;
	}

}
