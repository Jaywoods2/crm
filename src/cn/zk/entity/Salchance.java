package cn.zk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Salchance implements Serializable{
	private int chc_id;
	private String chc_source;
	private String chc_cust_name;
	private String chc_title;
	private int chc_rate;
	private String chc_linkman;
	private String chc_tel;
	private String chc_desc;
	private String chc_create_by;
	private Date chc_create_date;
	private String chc_due_to;
	private Date chc_due_date;
	private String chc_status;
	private Set<Salplan> plans; 
	public Salchance(){}
	
	
	public Set<Salplan> getPlans() {
		return plans;
	}


	public void setPlans(Set<Salplan> plans) {
		this.plans = plans;
	}


	public int getChc_id() {
		return chc_id;
	}
	public void setChc_id(int chcId) {
		chc_id = chcId;
	}
	public String getChc_source() {
		return chc_source;
	}
	public void setChc_source(String chcSource) {
		chc_source = chcSource;
	}
	public String getChc_cust_name() {
		return chc_cust_name;
	}
	public void setChc_cust_name(String chcCustName) {
		chc_cust_name = chcCustName;
	}
	public String getChc_title() {
		return chc_title;
	}
	public void setChc_title(String chcTitle) {
		chc_title = chcTitle;
	}
	public int getChc_rate() {
		return chc_rate;
	}
	public void setChc_rate(int chcRate) {
		chc_rate = chcRate;
	}
	public String getChc_linkman() {
		return chc_linkman;
	}
	public void setChc_linkman(String chcLinkman) {
		chc_linkman = chcLinkman;
	}
	public String getChc_tel() {
		return chc_tel;
	}
	public void setChc_tel(String chcTel) {
		chc_tel = chcTel;
	}
	public String getChc_desc() {
		return chc_desc;
	}
	public void setChc_desc(String chcDesc) {
		chc_desc = chcDesc;
	}
	public String getChc_create_by() {
		return chc_create_by;
	}
	public void setChc_create_by(String chcCreateBy) {
		chc_create_by = chcCreateBy;
	}
	public Date getChc_create_date() {
		return chc_create_date;
	}
	public void setChc_create_date(Date chcCreateDate) {
		chc_create_date = chcCreateDate;
	}
	public String getChc_due_to() {
		return chc_due_to;
	}
	public void setChc_due_to(String chcDueTo) {
		chc_due_to = chcDueTo;
	}
	public Date getChc_due_date() {
		return chc_due_date;
	}
	public void setChc_due_date(Date chcDueDate) {
		chc_due_date = chcDueDate;
	}
	public String getChc_status() {
		return chc_status;
	}
	public void setChc_status(String chcStatus) {
		chc_status = chcStatus;
	}
	
	
	/*sal_chance(
			[chc_id]
			[chc_source] [nvarchar](50) 
			[chc_cust_name] [nvarchar](100) NOT NULL,
			[chc_title] [nvarchar](200)  NOT NULL,
			[chc_rate] [int] NOT NULL   DEFAULT (0),
			[chc_linkman] [nvarchar](50)
			[chc_tel] [nvarchar](50) 
			[chc_desc] [nvarchar](2000)  NOT NULL,
			[chc_create_by] [nvarchar](50) NOT NULL,
			[chc_create_date] [datetime] NOT NULL 
			[chc_due_to] [nvarchar](50) 
			[chc_due_date] [datetime]
			[chc_status] [char](10) 
		)*/
}
