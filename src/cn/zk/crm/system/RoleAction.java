package cn.zk.crm.system;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_role;
import cn.zk.entity.Sys_user;
import cn.zk.service.LogService;
import cn.zk.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	private UserService userService;
	private LogService logService;
	private List<Sys_role> roles;
	private Sys_role role;
	private int role_id;

	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<Sys_role> getRoles() {
		return roles;
	}

	public void setRoles(List<Sys_role> roles) {
		this.roles = roles;
	}

	
	public Sys_role getRole() {
		return role;
	}

	public void setRole(Sys_role role) {
		this.role = role;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	public String all(){
		try {
			roles=userService.findAllRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String edit(){
		try {
			role=userService.findOneRole(role_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "edit";
	}
	
	public String update(){
		try {
			userService.updateRole(role);
			
			//--------日志------------
			Cst_log log=new Cst_log();
			HttpSession session=ServletActionContext.getRequest().getSession();
			Sys_user user=(Sys_user) session.getAttribute("user");	
			log.setLog_op(user.getUsr_name());
			log.setLog_event("修改了编号为：'"+role.getRole_id()+"' 的信息");
			log.setLog_date(new Date());
			logService.saveLogOne(log);
		//------------------------
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update";
	}
	
	
}
