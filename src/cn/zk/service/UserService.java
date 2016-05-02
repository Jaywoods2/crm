package cn.zk.service;

import java.util.List;

import cn.zk.entity.Sys_role;
import cn.zk.entity.Sys_user;
import cn.zk.util.PageUtil;


public interface UserService {
	public Sys_user findlogin(String username,String password) throws Exception;
	public List<Sys_user> findAllMgr() throws Exception;
	public List<Sys_role> findAllRole() throws Exception;
	public Sys_role findOneRole(int role_id) throws Exception;	
	public void updateRole(Sys_role role) throws Exception;
	public PageUtil<Sys_user> findAllUser(int curpage, int row) throws Exception ;
}
