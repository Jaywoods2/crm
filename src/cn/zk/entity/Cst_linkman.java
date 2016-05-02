package cn.zk.entity;

import java.io.Serializable;

public class Cst_linkman implements Serializable {
	private int lkm_id;
	private int lkm_cust_id;
	private String lkm_cust_no;
	private String lkm_cust_name;
	private String lkm_name;
	private String lkm_sex;
	private String lkm_postion;
	private String lkm_tel;
	private String lkm_mobile;
	private String lkm_memo;
	public Cst_linkman(){}
	public int getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(int lkmId) {
		lkm_id = lkmId;
	}
	public int getLkm_cust_id() {
		return lkm_cust_id;
	}
	public void setLkm_cust_id(int lkmCustId) {
		lkm_cust_id = lkmCustId;
	}
	public String getLkm_cust_no() {
		return lkm_cust_no;
	}
	public void setLkm_cust_no(String lkmCustNo) {
		lkm_cust_no = lkmCustNo;
	}
	public String getLkm_cust_name() {
		return lkm_cust_name;
	}
	public void setLkm_cust_name(String lkmCustName) {
		lkm_cust_name = lkmCustName;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkmName) {
		lkm_name = lkmName;
	}
	public String getLkm_sex() {
		return lkm_sex;
	}
	public void setLkm_sex(String lkmSex) {
		lkm_sex = lkmSex;
	}
	public String getLkm_postion() {
		return lkm_postion;
	}
	public void setLkm_postion(String lkmPostion) {
		lkm_postion = lkmPostion;
	}
	public String getLkm_tel() {
		return lkm_tel;
	}
	public void setLkm_tel(String lkmTel) {
		lkm_tel = lkmTel;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkmMobile) {
		lkm_mobile = lkmMobile;
	}
	public String getLkm_memo() {
		return lkm_memo;
	}
	public void setLkm_memo(String lkmMemo) {
		lkm_memo = lkmMemo;
	} 
	
}
