package cn.zk.crm.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_user;
import cn.zk.service.LogService;
import cn.zk.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;
	private LogService logService;
	private String username;
	private String password;
	private Sys_user user;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Sys_user getUser() {
		return user;
	}

	public void setUser(Sys_user user) {
		this.user = user;
	}

	public String login(){
		try {
			user=userService.findlogin(username, password);
			if(user!=null)
			{
				if(user.getUsr_flag()==-1){
					this.addFieldError("error", "用户已被冻结！");
					return INPUT;
				}
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			//----------加入日志-----------------------
				Cst_log log=new Cst_log();
				log.setLog_op(username);
				log.setLog_event("登录了系统");
				log.setLog_date(new Date());
				logService.saveLogOne(log);
			//---------------------------------------
			}
			else{
				this.addFieldError("error", "用户名或密码错误");
				return INPUT;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return SUCCESS;
	}
}
