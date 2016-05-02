package cn.zk.crm.customer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Cst_log;
import cn.zk.entity.Cst_lost;
import cn.zk.entity.Sys_user;
import cn.zk.service.CustomerService;
import cn.zk.service.LogService;

import com.opensymphony.xwork2.ActionSupport;

public class LostAction extends ActionSupport {
	private CustomerService customerService;
	private LogService logService;
	private List<Cst_lost> losts;
	private Cst_lost lost;
	private int lost_id;
	
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
	public List<Cst_lost> getLosts() {
		return losts;
	}
	public void setLosts(List<Cst_lost> losts) {
		this.losts = losts;
	}
	
	public Cst_lost getLost() {
		return lost;
	}
	public void setLost(Cst_lost lost) {
		this.lost = lost;
	}
	public int getLost_id() {
		return lost_id;
	}
	public void setLost_id(int lostId) {
		lost_id = lostId;
	}
	public String list() throws Exception{
		customerService.saveLoster();
		losts=customerService.findLoster();
		return "list";
	}
	public String comfirm() throws Exception{
		lost=customerService.findLosterById(lost_id);
		return "comfirm";
	}
	public String update() throws Exception{
		Cst_lost lost2=customerService.findLosterById(lost.getLost_id());
		lost2.setLost_why(lost.getLost_why());
		lost2.setLost_statue(1);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date=format.format(new Date());
		lost2.setLost_okdate(date);
		customerService.updateLost(lost2);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("确认了客户："+lost2.getLost_cust_name()+" 的流失");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "update";
	}
}
