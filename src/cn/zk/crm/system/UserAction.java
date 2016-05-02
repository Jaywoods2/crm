package cn.zk.crm.system;

import java.util.List;
import cn.zk.entity.Sys_user;
import cn.zk.service.UserService;
import cn.zk.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;
	private PageUtil<Sys_user> pages;
	private Sys_user role;
	private int usr_id;
	private int curpage=1;
	private int pgs;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public PageUtil<Sys_user> getPages() {
		return pages;
	}
	public void setPages(PageUtil<Sys_user> pages) {
		this.pages = pages;
	}
	public Sys_user getRole() {
		return role;
	}
	public void setRole(Sys_user role) {
		this.role = role;
	}
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usrId) {
		usr_id = usrId;
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
	
	public String all(){
		try {
			pages=userService.findAllUser(curpage, 5);
			pgs=pages.getPages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
