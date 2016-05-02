package cn.zk.entity;

import java.io.Serializable;
import java.util.Set;

public class Orders implements Serializable {
	private int odr_id;
	private int odr_cust_id;
	private String odr_customer;
	private String odr_date;
	private String odr_addr;
	private char odr_status;
	private Set<Orders_line> odds;

	public Orders() {
	}

	public int getOdr_id() {
		return odr_id;
	}

	public void setOdr_id(int odrId) {
		odr_id = odrId;
	}

	public int getOdr_cust_id() {
		return odr_cust_id;
	}

	public void setOdr_cust_id(int odrCustId) {
		odr_cust_id = odrCustId;
	}

	public String getOdr_customer() {
		return odr_customer;
	}

	public void setOdr_customer(String odrCustomer) {
		odr_customer = odrCustomer;
	}

	public String getOdr_date() {
		return odr_date;
	}

	public void setOdr_date(String odrDate) {
		odr_date = odrDate;
	}

	public String getOdr_addr() {
		return odr_addr;
	}

	public void setOdr_addr(String odrAddr) {
		odr_addr = odrAddr;
	}

	public char getOdr_status() {
		return odr_status;
	}

	public void setOdr_status(char odrStatus) {
		odr_status = odrStatus;
	}

	public Set<Orders_line> getOdds() {
		return odds;
	}

	public void setOdds(Set<Orders_line> odds) {
		this.odds = odds;
	}
	

}
