package cn.zk.entity;

import java.io.Serializable;

public class Cst_activity implements Serializable {
	private int atv_id;
	private int atv_cust_id;
	private String atv_cust_no;
	private String atv_cust_name;
	private String atv_date;
	private String atv_place;
	private String atv_title;
	private String atv_desc;
	public Cst_activity(){}
	public int getAtv_id() {
		return atv_id;
	}
	public void setAtv_id(int atvId) {
		atv_id = atvId;
	}
	public int getAtv_cust_id() {
		return atv_cust_id;
	}
	public void setAtv_cust_id(int atvCustId) {
		atv_cust_id = atvCustId;
	}
	public String getAtv_cust_no() {
		return atv_cust_no;
	}
	public void setAtv_cust_no(String atvCustNo) {
		atv_cust_no = atvCustNo;
	}
	public String getAtv_cust_name() {
		return atv_cust_name;
	}
	public void setAtv_cust_name(String atvCustName) {
		atv_cust_name = atvCustName;
	}


	public String getAtv_date() {
		return atv_date;
	}
	public void setAtv_date(String atvDate) {
		atv_date = atvDate;
	}
	public String getAtv_place() {
		return atv_place;
	}
	public void setAtv_place(String atvPlace) {
		atv_place = atvPlace;
	}
	public String getAtv_title() {
		return atv_title;
	}
	public void setAtv_title(String atvTitle) {
		atv_title = atvTitle;
	}
	public String getAtv_desc() {
		return atv_desc;
	}
	public void setAtv_desc(String atvDesc) {
		atv_desc = atvDesc;
	}
	
	
	
}
