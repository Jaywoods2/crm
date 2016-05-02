package cn.zk.crm.customer;

import java.util.List;

import cn.zk.entity.Cst_customer;
import cn.zk.service.CustomerService;
import cn.zk.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	private CustomerService customerService;
	private List<Cst_customer> cslist;
	private int curpage=1;
	private int pgs;
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	public String all() throws Exception{

		PageUtil<Cst_customer>  pages=customerService.findCstPage(curpage, 2);
		pgs=pages.getPages();
		cslist=pages.getData();
		//System.out.println("..");
		return "all";
	}
	
}
