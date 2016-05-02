package cn.zk.dao;

import java.util.List;

import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_user;
import cn.zk.util.PageUtil;

public interface LogDAO {
	public void addLogOne(Cst_log log) throws Exception;
	
	public PageUtil<Cst_log> queryAllLogPage(int curpage,int row) throws Exception;

	public List<Cst_log> getAllLog() throws Exception;
	
	
	
}
