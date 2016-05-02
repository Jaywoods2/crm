package cn.zk.crm.sale;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_log;
import cn.zk.entity.Salchance;
import cn.zk.entity.Salplan;
import cn.zk.entity.Sys_user;
import cn.zk.service.LogService;
import cn.zk.service.SalchanceService;
import cn.zk.service.UserService;
import cn.zk.util.PageUtil;

public class SalAction extends ActionSupport{
	private Set<Salplan> ssp;
	private Salchance sc;
	private List<Salchance> ssc;
	private int curpage=1;
	private int pgs;
	private SalchanceService salchanceService;
	private LogService logService;
    private int chc_id;
    private UserService userservice;
    private List<Sys_user> uls;
    private int rows;
    private Cst_customer  cc;
   
    
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Cst_customer getCc() {
		return cc;
	}

	public void setCc(Cst_customer cc) {
		this.cc = cc;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Set<Salplan> getSsp() {
		return ssp;
	}

	public void setSsp(Set<Salplan> ssp) {
		this.ssp = ssp;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public List<Sys_user> getUls() {
		return uls;
	}

	public void setUls(List<Sys_user> uls) {
		this.uls = uls;
	}

	public int getPgs() {
		return pgs;
	}

	public void setPgs(int pgs) {
		this.pgs = pgs;
	}

	public int getChc_id() {
		return chc_id;
	}

	public void setChc_id(int chcId) {
		chc_id = chcId;
	}

	public List<Salchance> getSsc() {
		return ssc;
	}

	public void setSsc(List<Salchance> ssc) {
		this.ssc = ssc;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public SalchanceService getSalchanceService() {
		return salchanceService;
	}

	public void setSalchanceService(SalchanceService salchanceService) {
		this.salchanceService = salchanceService;
	}

	public Salchance getSc() {
		return sc;
	}

	public void setSc(Salchance sc) {
		this.sc = sc;
	}
	/*
	 *添加机会 
	 * */
	public String add() throws Exception {
		// TODO Auto-generated method stub
		sc.setChc_status("未分配");
		sc.setChc_create_date(new Date());
		salchanceService.saveChanceService(sc);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("创建了一条销售机会");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return SUCCESS;
	}
	/**
	 * 查询所有机会
	 * @return
	 * @throws Exception
	 */
	public String findall() throws Exception {
		// TODO Auto-generated method stub
		PageUtil<Salchance>  pages=salchanceService.findSalchanceByPageService(curpage, 2);
		pgs=pages.getPages();
		ssc=pages.getData();
		//salchanceService.saveChanceService(sc);
		return "findchance";
	}
	/**
	 * 更新机会
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		sc.setChc_status("未分配");
		salchanceService.updateChanceService(sc);
		
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("修改一条编号为：'"+sc.getChc_id()+"'销售机会");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
		//------------------------
		return "update";
	}
	public String findOneSalchance() throws Exception{
		sc=salchanceService.findOneSalchance(chc_id);
		return "findsalchance";
	}
	public String deleteSalchance() throws Exception{
		salchanceService.deleteSalchance(chc_id);
		
		//--------日志------------
		Cst_log log=new Cst_log();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Sys_user user=(Sys_user) session.getAttribute("user");	
		log.setLog_op(user.getUsr_name());
		log.setLog_event("删除了一条编号为：'"+chc_id+"'销售机会");
		log.setLog_date(new Date());
		logService.saveLogOne(log);
	//------------------------
		return "delete";
	}
	public String dueSalchance() throws Exception{
		uls=userservice.findAllMgr();
		sc=salchanceService.findOneSalchance(chc_id);
		return "dueSalchance";
}
	public String findplan() throws Exception {
		// TODO Auto-generated method stub
		PageUtil<Salchance>  pages=salchanceService.findSalplanByPageService(curpage, 2);
		pgs=pages.getPages();
		ssc=pages.getData();
		//salchanceService.saveChanceService(sc);
		return "findplan";
	}
	/**
	 * 指派机会
	 * @return
	 * @throws Exception
	 */
	public String dispatch() throws Exception{
		sc=salchanceService.findOneSalchance(chc_id);
		sc.setChc_status("开发中");
		sc.setChc_due_date(new Date());
		salchanceService.updateChanceService(sc);
		return "update";
	}
	public String doplan() throws Exception{
		sc=salchanceService.findOneSalchance(chc_id);
		ssp=sc.getPlans();
		return "doplan";
	}
	public String todoplan() throws Exception{
		sc=salchanceService.findOneSalchance(chc_id);
		ssp=sc.getPlans();
		return "todoplan";
	}
    public String findbycon() throws Exception{
    	PageUtil<Salchance>  pages=salchanceService.findSalPageByCon(curpage, 2, sc);
		pgs=pages.getPages();
		ssc=pages.getData();
    	return "findchance";
    }	
    public String findbycon2() throws Exception{
    	PageUtil<Salchance>  pages=salchanceService.findSalPageByConn(curpage, 2, sc);
		pgs=pages.getPages();
		ssc=pages.getData();
    	return "findplan";
    }	
    public String planresult() throws Exception{
    	sc=salchanceService.findOneSalchance(chc_id);
    	sc.setChc_status("已归档");
    	salchanceService.updateChanceService(sc);
    	/*cc.setCust_no(sc.getChc_id()+"");
    	cc.setCust_name(sc.getChc_cust_name());
    	cc.setCust_manager_name(sc.getChc_due_to());*/
    	//cc.getCust_manager_name();
    int mgrid=	salchanceService.findUsr_idByName(cc.getCust_manager_name());
    	cc.setCust_status('1');
    	cc.setCust_manager_id(mgrid);
    	cc.setCust_level(1);
    	cc.setCust_level_label("普通客户");
    	salchanceService.saveCustomerService(cc);
    	
    	return "planresult";
    }   
    public String findtoplan() throws Exception{
    	sc=salchanceService.findOneSalchance(chc_id);
		ssp=sc.getPlans();
    	return "findtoplan";
    }   
}