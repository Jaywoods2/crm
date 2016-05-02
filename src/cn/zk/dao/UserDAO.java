package cn.zk.dao;

import java.util.List;

import cn.zk.entity.Sys_role;
import cn.zk.entity.Sys_user;
import cn.zk.util.PageUtil;

public interface UserDAO {
	public Sys_user login(String username,String password) throws Exception;
	public List<Sys_user> getAllMgr() throws Exception;
	
	public List<Sys_role> getAllRole()throws Exception;
	
	public Sys_role getOneRole(int role_id) throws Exception;
	
	public void updateRole(Sys_role role) throws Exception;
	
	public PageUtil<Sys_user> getAllUser(int curpage, int row) throws Exception;
}
