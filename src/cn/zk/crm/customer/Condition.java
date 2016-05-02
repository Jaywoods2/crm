package cn.zk.crm.customer;

public class Condition {
	private String cust_no;
	private String cust_name;
	private String cust_manager_name;
	private String cust_addr;
	private String cust_level_label;

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String custNo) {
		cust_no = custNo;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String custName) {
		cust_name = custName;
	}

	public String getCust_manager_name() {
		return cust_manager_name;
	}

	public void setCust_manager_name(String custManagerName) {
		cust_manager_name = custManagerName;
	}

	public String getCust_addr() {
		return cust_addr;
	}

	public void setCust_addr(String custAddr) {
		cust_addr = custAddr;
	}

	public String getCust_level_label() {
		return cust_level_label;
	}

	public void setCust_level_label(String custLevelLabel) {
		cust_level_label = custLevelLabel;
	}

}
