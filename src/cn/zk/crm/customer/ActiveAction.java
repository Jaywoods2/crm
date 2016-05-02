package cn.zk.crm.customer;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Cst_activity;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_user;
import cn.zk.service.CustomerService;
import cn.zk.service.LogService;

import com.opensymphony.xwork2.ActionSupport;

public class ActiveAction extends ActionSupport {
	private CustomerService customerService;
	private LogService logService;
	private int cust_id;
	private Cst_customer cs;
	private Set<Cst_activity> atvs;
	private Cst_activity atv;
	private int atv_id;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int custId) {
		cust_id = custId;
	}
	
	public Cst_customer getCs() {
		return cs;
	}

	public void setCs(Cst_customer cs) {
		this.cs = cs;
	}

	public Set<Cst_activity> getAtvs() {
		return atvs;
	}

	public void setAtvs(Set<Cst_activity> atvs) {
		this.atvs = atvs;
	}
	
	public Cst_activity getAtv() {
		return atv;
	}

	public void setAtv(Cst_activity atv) {
		this.atv = atv;
	}
	
	public int getAtv_id() {
		return atv_id;
	}

	public void setAtv_id(int atvId) {
		atv_id = atvId;
	}

	public String alist(){
		try {
			cs=customerService.findCustomerById(cust_id);
			atvs=cs.getAtvs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String add(){
		try {
			cs=customerService.findCustomerById(cust_id);
			atv.setAtv_cust_id(cust_id);
			atv.setAtv_cust_no(cs.getCust_no());
			atv.setAtv_cust_name(cs.getCust_name());
			customerService.saveCst_activity(atv);
			//--------日志------------
				Cst_log log=new Cst_log();
				HttpSession session=ServletActionContext.getRequest().getSession();
				Sys_user user=(Sys_user) session.getAttribute("user");	
				log.setLog_op(user.getUsr_name());
				log.setLog_event("添加了一条客户："+atv.getAtv_cust_name()+" 的交互记录");
				log.setLog_date(new Date());
				logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "addsuc";
		
	}
	public String queryone(){
		try {
			atv=	customerService.findAtvById(atv_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "qone";
	}
	public String edit() throws Exception{
		customerService.updateAtv(atv);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("修改了一条与客户："+atv.getAtv_cust_name()+"的交互记录");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
		//------------------------
		return "esuc";
	}
	public String del(){
		try {
			customerService.deleteAtv(atv_id);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("删除了一条与客户："+atv.getAtv_cust_name()+"的交互记录");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "esuc";
	}
}
