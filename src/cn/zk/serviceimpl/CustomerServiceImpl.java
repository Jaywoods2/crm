package cn.zk.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import cn.zk.crm.customer.Condition;
import cn.zk.dao.CustomerDAO;
import cn.zk.entity.Cst_activity;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_linkman;
import cn.zk.entity.Cst_lost;
import cn.zk.entity.Orders;
import cn.zk.service.CustomerService;
import cn.zk.util.PageUtil;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<Cst_customer> findallCustomer() throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.allCustomer();
	}

	public List<Cst_customer> findCustomerPage(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.customerPage(curpage, row);
	}

	public Cst_customer findCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryCustomerById(id);
	}

	public void updateCustomer(Cst_customer c) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(c);
		
	}

	public void saveLinkMan(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.addLinkMan(lkm);
	}

	public void deleteLinkMan(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.deleteLinkMan(id);
	}

	public Cst_linkman findLinkmanById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryLinkmanById(id);
	}

	public void updateLinkman(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.updateLinkman(lkm);
	}

	public void deleteCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.delCustomerById(id);
	}

	public void saveCst_activity(Cst_activity av) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.addCst_activity(av);
	}

	public Cst_activity findAtvById(Serializable atv_id) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryAtvById(atv_id);
	}

	public void updateAtv(Cst_activity at) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.updateAtv(at);
	}

	public void deleteAtv(Serializable atvId) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.deleteAtv(atvId);
	}

	public PageUtil<Cst_customer> findCstPage(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryCstPage(curpage, row);
	}

	public Orders findOrderById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryOrderById(id);
	}

	public PageUtil<Cst_customer> findCstPageByCon(int curpage, int row,
			Condition con) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.queryCstPageByCon(curpage, row, con);
	}

	public void saveLoster() throws Exception {
		// TODO Auto-generated method stub
		customerDAO.insertLoster();
	}

	public List<Cst_lost> findLoster() throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.getLoster();
	}

	public Cst_lost findLosterById(Serializable lostId) throws Exception {
		// TODO Auto-generated method stub
		return customerDAO.getLosterById(lostId);
	}

	public void updateLost(Cst_lost lost) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.updateLost(lost);
	}

	
	
}
