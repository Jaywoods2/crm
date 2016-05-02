package cn.zk.serviceimpl;

import java.util.List;

import cn.zk.dao.LogDAO;
import cn.zk.entity.Cst_log;
import cn.zk.service.LogService;
import cn.zk.util.PageUtil;

public class LogServiceImpl implements LogService {
	private LogDAO logDAO;

	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public void saveLogOne(Cst_log log) throws Exception {
		// TODO Auto-generated method stub
		logDAO.addLogOne(log);
	}

	public PageUtil<Cst_log> findAllLogPage(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		return logDAO.queryAllLogPage(curpage, row);
	}

	public List<Cst_log> findAllLog() throws Exception {
		// TODO Auto-generated method stub
		return logDAO.getAllLog();
	}
	
	
}
