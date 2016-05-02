package cn.zk.crm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Condition;
import cn.zk.entity.Cst_log;
import cn.zk.entity.Cst_service;
import cn.zk.entity.Sys_user;
import cn.zk.service.Cst_serviceService;
import cn.zk.service.LogService;

import com.opensymphony.xwork2.ActionSupport;

public class cst_serviceAction extends ActionSupport {

	private Cst_serviceService cst_serviceService;
	private Cst_service cs;
	private LogService logService;
	private int curPage;
	private Condition con;
	private Date svr_due_date;
	private List<Object> cus;
	private List<Object> sys;
	private final static int row = 4;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Date getSvr_due_date() {
		return svr_due_date;
	}

	public void setSvr_due_date(Date svrDueDate) {
		svr_due_date = svrDueDate;
	}

	public Cst_serviceService getCst_serviceService() {
		return cst_serviceService;
	}

	public void setCst_serviceService(Cst_serviceService cstServiceService) {
		cst_serviceService = cstServiceService;
	}

	public Cst_service getCs() {
		return cs;
	}

	public void setCs(Cst_service cs) {
		this.cs = cs;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public Condition getCon() {
		return con;
	}

	public void setCon(Condition con) {
		this.con = con;
	}

	public List<Object> getSys() {
		return sys;
	}

	public void setSys(List<Object> sys) {
		this.sys = sys;
	}

	public List<Object> getCus() {
		return cus;
	}

	public void setCus(List<Object> cus) {
		this.cus = cus;
	}

	public String addService() throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String svr_due_date = format.format(new Date());
		cs.setSvr_create_date(svr_due_date);
		cs.setSvr_status("新创建");
		cst_serviceService.save(cs);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("添加了一条服务");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "add";
	}

	public String findBycon() throws Exception {

		sys = cst_serviceService.findSys_user();
		List<Cst_service> res = cst_serviceService.findByHQLCondition(con,
				curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findBycon",
				"/pages/~cust/service/cst_service_findBycon.action");
		return "findBycon";

	}

	public String findBycon1() throws Exception {

		List<Cst_service> res = cst_serviceService.findByHQLCondition(con,
				curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findBycon1",
				"/pages/~cust/service/cst_service_findBycon1.action");
		return "findBycon1";

	}

	public String findBycon2() throws Exception {

		List<Cst_service> res = cst_serviceService.findByHQLCondition(con,
				curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findBycon2",
				"/pages/~cust/service/cst_service_findBycon2.action");
		return "findBycon2";

	}

	public String findBycon3() throws Exception {

		List<Cst_service> res = cst_serviceService.findByHQLCondition(con,
				curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findBycon3",
				"/pages/~cust/service/cst_service_findBycon3.action");
		return "findBycon3";

	}

	public String findAll() throws Exception {

		sys = cst_serviceService.findSys_user();
		List<Cst_service> res = cst_serviceService.findAll(curPage, row);
		int Rows = cst_serviceService.getdateRow(con);

		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findAll",
				"/pages/~cust/service/cst_service_findAll.action");
		return "findBycon";

	}

	public String findWithfp() throws Exception {
		List<Cst_service> res = cst_serviceService.findByfp(curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findwithfp",
				"/pages/~cust/service/cst_service_findWithfp.action");
		return "findwithfp";

	}

	public String findWithcl() throws Exception {
		List<Cst_service> res = cst_serviceService.findBycl(curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findwithcl",
				"/pages/~cust/service/cst_service_findWithcl.action");
		return "findwithcl";
	}

	public String findWithgd() throws Exception {
		List<Cst_service> res = cst_serviceService.findBygd(curPage, row);
		int Rows = cst_serviceService.getdateRow(con);
		int pages = 1;
		if (Rows % row == 0) {
			pages = Rows / row;
		} else {
			pages = Rows / row + 1;
		}
		ServletActionContext.getRequest().setAttribute("curPage", curPage);
		ServletActionContext.getRequest().setAttribute("pages", pages);
		ServletActionContext.getRequest().setAttribute("res", res);
		ServletActionContext.getRequest().setAttribute("findwithgd",
				"/pages/~cust/service/cst_service_findWithgd.action");
		return "findwithgd";
	}

	public String deleteinfo() throws Exception {

		cst_serviceService.delete(cs.getSvr_id());
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("删除了一条服务");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "delete";
	}

	public String updateinfo() throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String svr_due_date = format.format(new Date());
		cs.setSvr_due_date(svr_due_date);
		cs.setSvr_status("已分配");
		cst_serviceService.updateCst_serviceById(cs.getSvr_id(), cs
				.getSvr_due_to(), cs.getSvr_due_date(), cs.getSvr_status());
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("给编号为："+cs.getSvr_id()+" 的服务分配了给了：'"+cs.getSvr_due_to()+"'");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "delete";
	}

	public String queryOneById() throws Exception {
		Cst_service cst = cst_serviceService.queryOneByid(cs.getSvr_id());
		ServletActionContext.getRequest().setAttribute("cst", cst);
		return "querySuc";
	}

	public String updateDeal() throws Exception {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String svr_deal_date = format.format(new Date());
		cs.setSvr_deal_date(svr_deal_date);
		cs.setSvr_status("已处理");
		cst_serviceService.updateinfo(cs);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("处理了一条编号为："+cs.getSvr_id()+" 的服务");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "updateSuc";
	}

	public String queryOne() throws Exception {
		Cst_service cst = cst_serviceService.queryOneByid(cs.getSvr_id());
		ServletActionContext.getRequest().setAttribute("cst", cst);
		return "queryOne";
	}

	public String deal() throws Exception {
		if (cs.getSvr_satisfy() > 3 || cs.getSvr_satisfy() == 3) {
			cs.setSvr_status("已归档");
		} else {
			cs.setSvr_status("已分配");
		}
		cst_serviceService.Dealresult(cs.getSvr_id(), cs.getSvr_result(), cs
				.getSvr_satisfy(), cs.getSvr_status());
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("进行编号为："+cs.getSvr_id()+" 的服务反馈");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "deal";
	}

	public String queryResult() throws Exception {
		Cst_service cst = cst_serviceService.queryOneByid(cs.getSvr_id());
		ServletActionContext.getRequest().setAttribute("cst", cst);

		return "queryR";
	}

	public String findAllCus_name() throws Exception {
		cus = cst_serviceService.findAllCus();

		return "cust_name";
	}

}
