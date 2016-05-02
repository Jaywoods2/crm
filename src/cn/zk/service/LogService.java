package cn.zk.service;

import java.util.List;

import cn.zk.entity.Cst_log;
import cn.zk.util.PageUtil;


public interface LogService {
	public void saveLogOne(Cst_log log) throws Exception;
	
	public PageUtil<Cst_log> findAllLogPage(int curpage,int row) throws Exception;

	public List<Cst_log> findAllLog() throws Exception;
}
