package cn.zk.crm.customer;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_linkman;
import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_user;
import cn.zk.service.CustomerService;
import cn.zk.service.LogService;
import cn.zk.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	private CustomerService customerService;
	private LogService logService;
	private int cust_id;
	private Cst_customer cs;
	private Set<Cst_linkman> lkms;
	private Cst_linkman lkm;
	private int lkm_id;
	private UserService userService;
	private List<Sys_user> uls;
	
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
	
	public Cst_linkman getLkm() {
		return lkm;
	}
	public void setLkm(Cst_linkman lkm) {
		this.lkm = lkm;
	}
	
	public Set<Cst_linkman> getLkms() {
		return lkms;
	}
	public void setLkms(Set<Cst_linkman> lkms) {
		this.lkms = lkms;
	}
	
	public int getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(int lkmId) {
		lkm_id = lkmId;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<Sys_user> getUls() {
		return uls;
	}
	public void setUls(List<Sys_user> uls) {
		this.uls = uls;
	}
	
	//通过客户id查询某个客户的信息并返还到客户信息编辑界面显示。
	public String query(){
		try {
			cs=customerService.findCustomerById(cust_id);
			uls=userService.findAllMgr();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "qedit";
	}
	
	//从客户编辑界面得到数据修改客户信息
	public String change(){
		try {
			String label=cs.getCust_level_label();
			String [] level=label.split(",");
				cs.setCust_level(Integer.parseInt(level[0]));
				cs.setCust_level_label(level[1]);
			//System.out.println("..");
			String mgr=cs.getCust_manager_name();
			String [] m=mgr.split(",");
				cs.setCust_manager_id(Integer.parseInt(m[0]));
				cs.setCust_manager_name(m[1]);
			customerService.updateCustomer(cs);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("修改了客户：'"+cs.getCust_name()+"' 的信息");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "change";
	}
	
	//通过客户id查询所属的所有联系人
	public String lkm(){
		try {
			cs=customerService.findCustomerById(cust_id);
			lkms=cs.getKinks();
			//System.out.println("..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lkm";
	}
	
	
	//添加联系人
	public String addlkm(){
		try {
			cs=customerService.findCustomerById(cust_id);
			lkm.setLkm_cust_id(cust_id);
			lkm.setLkm_cust_no(cs.getCust_no());
			lkm.setLkm_cust_name(cs.getCust_name());
			
			customerService.saveLinkMan(lkm);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("添加了客户：'"+cs.getCust_name()+"' 的联系人:'"+lkm.getLkm_name()+"'");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suc";
	}
	
	//删除联系人
	public String dellkm(){
		try {
			customerService.deleteLinkMan(lkm_id);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("删除了一条联系人");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suc";
	}
	
	//通过联系人id查询他的信息，返回到联系人编辑界面
	public String lkmone(){
		try {
			lkm=customerService.findLinkmanById(lkm_id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "one";
	}
	
	//更新联系人
	public String uplkm(){
		try {
			customerService.updateLinkman(lkm);
			

			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("修改了客户：'"+lkm.getLkm_cust_name()+"' 的联系人：'"+lkm.getLkm_name()+"'");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "upsuc";
	
	}
	
	//通过客户id删除客户信息
	public String delcst(){
		try {
			customerService.deleteCustomerById(cust_id);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("删除了一个客户");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
			//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "delcst";
	}
}
