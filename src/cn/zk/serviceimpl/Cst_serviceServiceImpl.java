package cn.zk.serviceimpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.zk.dao.Cst_serviceDao;
import cn.zk.entity.Condition;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_service;
import cn.zk.service.Cst_serviceService;

public class Cst_serviceServiceImpl implements Cst_serviceService {

	private Cst_serviceDao cst_servicedao;

	public Cst_serviceDao getCst_servicedao() {
		return cst_servicedao;
	}

	public void setCst_servicedao(Cst_serviceDao cstServicedao) {
		cst_servicedao = cstServicedao;
	}

	public void save(Cst_service cst_service) throws Exception {
		cst_servicedao.save(cst_service);
	}

	public List<Cst_service> findByHQLCondition(Condition con, int curPage,
			int row) throws Exception {
		return cst_servicedao.findByHQLCondition(con, curPage, row);
	}

	public int getdateRow(Condition con) throws Exception {
		return cst_servicedao.getdateRow(con);
	}

	public List<Cst_service> findAll(int curPage, int row) throws Exception {
		return cst_servicedao.findAll(curPage, row);
	}

	public void delete(Serializable svr_id) throws Exception {
		cst_servicedao.delete(svr_id);
	}

	public void updateCst_serviceById(Serializable id, String svr_due_to,
			String svr_due_date, String svr_status) throws Exception {
		cst_servicedao.updateCst_serviceById(id, svr_due_to, svr_due_date,
				svr_status);
	}

	public Cst_service queryOneByid(Serializable svr_id) {
		return cst_servicedao.queryOneByid(svr_id);
	}

	public void updateinfo(Cst_service cst_service) throws Exception {
		cst_servicedao.updateinfo(cst_service);
	}

	public void Dealresult(Serializable id, String svr_result, int svr_satisfy,
			String svr_status) throws Exception {
		cst_servicedao.Dealresult(id, svr_result, svr_satisfy, svr_status);
	}

	public List<Cst_service> findByfp(int curPage, int row) throws Exception {
		return cst_servicedao.findByfp(curPage, row);
	}

	public List<Cst_service> findBycl(int curPage, int row) throws Exception {
		return cst_servicedao.findBycl(curPage, row);
	}

	public List<Cst_service> findBygd(int curPage, int row) throws Exception {
		return cst_servicedao.findBygd(curPage, row);
	}

	public List<Object> findAllCus() throws Exception {
		// TODO Auto-generated method stub
		return cst_servicedao.findAllCus();
	}

	public List<Object> findSys_user() throws Exception {
		// TODO Auto-generated method stub
		return cst_servicedao.findSys_user();
	}

}
