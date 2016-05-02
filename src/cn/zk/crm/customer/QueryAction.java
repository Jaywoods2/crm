package cn.zk.crm.customer;

import java.util.List;

import cn.zk.entity.Cst_customer;
import cn.zk.service.CustomerService;
import cn.zk.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class QueryAction extends ActionSupport {
     private CustomerService customerService;
     private Condition con;
     private List<Cst_customer> cslist;
 	 private int curpage=1;
     private int pgs;
     private int rows;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Condition getCon() {
		return con;
	}

	public void setCon(Condition con) {
		this.con = con;
	}
	
    public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<Cst_customer> getCslist() {
		return cslist;
	}

	public void setCslist(List<Cst_customer> cslist) {
		this.cslist = cslist;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPgs() {
		return pgs;
	}

	public void setPgs(int pgs) {
		this.pgs = pgs;
	}
	//查询所有的客户列表，并分页
	public String query(){
    	try {
    		if(con!=null){
    		if(con.getCust_no().length()==0){
    			con.setCust_no(null);
    		}
    		if(con.getCust_name().length()==0){
    			con.setCust_name(null);
    		}
    		if(con.getCust_addr().length()==0){
    			con.setCust_addr(null);
    		}
    		if(con.getCust_manager_name().length()==0){
    			con.setCust_manager_name(null);
    		}
    		if(con.getCust_level_label().length()==0){
    			con.setCust_level_label(null);
    		}}
    		PageUtil<Cst_customer>  pages=customerService.findCstPageByCon(curpage, 2, con);
    		pgs=pages.getPages();
    		cslist=pages.getData();
    		rows=pages.getRows();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return SUCCESS;
    }
}
