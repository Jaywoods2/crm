package cn.zk.serviceimpl;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

import cn.zk.dao.JfreeDAO;
import cn.zk.service.JfreeService;

public class JfreeServiceImpl implements JfreeService {
	private JfreeDAO jfreeDAO;
	
	public JfreeDAO getJfreeDAO() {
		return jfreeDAO;
	}

	public void setJfreeDAO(JfreeDAO jfreeDAO) {
		this.jfreeDAO = jfreeDAO;
	}

	public CategoryDataset findCstcontribute(String cust_name,String year) throws Exception {
		// TODO Auto-generated method stub
		return jfreeDAO.Cstcontribute(cust_name,year);
	}

	public CategoryDataset findCstMakeup(int condit) throws Exception {
		// TODO Auto-generated method stub
		return jfreeDAO.CstMakeup(condit);
	}

	public CategoryDataset findCstService(String year) throws Exception {
		// TODO Auto-generated method stub
		return jfreeDAO.CstService(year);
	}

}
