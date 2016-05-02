package cn.zk.entity;

import java.io.Serializable;
import java.util.Date;

public class Condition implements Serializable{

	private String svr_cust_name;
	private String svr_title;
	private String svr_type;
	private String mindate;
	private String maxdate;
	private String svr_status;
	public String getSvr_cust_name() {
		return svr_cust_name;
	}
	public void setSvr_cust_name(String svrCustName) {
		svr_cust_name = svrCustName;
	}
	public String getSvr_title() {
		return svr_title;
	}
	public void setSvr_title(String svrTitle) {
		svr_title = svrTitle;
	}
	public String getSvr_type() {
		return svr_type;
	}
	public void setSvr_type(String svrType) {
		svr_type = svrType;
	}
	public String getMindate() {
		return mindate;
	}
	public void setMindate(String mindate) {
		this.mindate = mindate;
	}
	public String getMaxdate() {
		return maxdate;
	}
	public void setMaxdate(String maxdate) {
		this.maxdate = maxdate;
	}
	public String getSvr_status() {
		return svr_status;
	}
	public void setSvr_status(String svrStatus) {
		svr_status = svrStatus;
	}
	
}
