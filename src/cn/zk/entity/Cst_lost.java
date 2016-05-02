package cn.zk.entity;

import java.io.Serializable;

public class Cst_lost implements Serializable {
	private int lost_id;
	private int lost_cust_id;
	private String lost_cust_name;
	private String lost_mgr;
	private String lost_last_odrdate;
	private String lost_okdate;
	private String lost_step;
	private String lost_stepadd;
	private String lost_why;
	private int lost_statue;
	public int getLost_id() {
		return lost_id;
	}
	public void setLost_id(int lostId) {
		lost_id = lostId;
	}
	public String getLost_cust_name() {
		return lost_cust_name;
	}
	public void setLost_cust_name(String lostCustName) {
		lost_cust_name = lostCustName;
	}
	public String getLost_mgr() {
		return lost_mgr;
	}
	public void setLost_mgr(String lostMgr) {
		lost_mgr = lostMgr;
	}
	public String getLost_last_odrdate() {
		return lost_last_odrdate;
	}
	public void setLost_last_odrdate(String lostLastOdrdate) {
		lost_last_odrdate = lostLastOdrdate;
	}
	public String getLost_step() {
		return lost_step;
	}
	public void setLost_step(String lostStep) {
		lost_step = lostStep;
	}
	public String getLost_stepadd() {
		return lost_stepadd;
	}
	public void setLost_stepadd(String lostStepadd) {
		lost_stepadd = lostStepadd;
	}
	public String getLost_why() {
		return lost_why;
	}
	public void setLost_why(String lostWhy) {
		lost_why = lostWhy;
	}
	public int getLost_statue() {
		return lost_statue;
	}
	public void setLost_statue(int lostStatue) {
		lost_statue = lostStatue;
	}
	public String getLost_okdate() {
		return lost_okdate;
	}
	public void setLost_okdate(String lostOkdate) {
		lost_okdate = lostOkdate;
	}
	public int getLost_cust_id() {
		return lost_cust_id;
	}
	public void setLost_cust_id(int lostCustId) {
		lost_cust_id = lostCustId;
	}

	
}
