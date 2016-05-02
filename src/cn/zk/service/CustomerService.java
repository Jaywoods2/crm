package cn.zk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import cn.zk.crm.customer.Condition;
import cn.zk.entity.Cst_activity;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_linkman;
import cn.zk.entity.Cst_lost;
import cn.zk.entity.Orders;
import cn.zk.util.PageUtil;

public interface CustomerService {
	public List<Cst_customer> findallCustomer() throws Exception;
	
	/**
	 * 分页查询Cst_customer
	 * @param curpage
	 * @param row
	 * @return
	 */
	public List<Cst_customer> findCustomerPage(int curpage, int row) throws Exception; 
	
	public Cst_customer findCustomerById(Serializable id)throws Exception;
	
	public void updateCustomer(Cst_customer c) throws Exception;
	
	public void saveLinkMan(Cst_linkman lkm) throws Exception;
	
	public void deleteLinkMan(Serializable id) throws Exception;
	
	public Cst_linkman findLinkmanById(Serializable id) throws Exception;

	public void updateLinkman(Cst_linkman lkm) throws Exception ;
	
	public void deleteCustomerById(Serializable id) throws Exception;
	
	public void saveCst_activity(Cst_activity av) throws Exception;
	
	public Cst_activity findAtvById(Serializable atv_id) throws Exception;
	
	public void updateAtv(Cst_activity at) throws Exception;
	
	public void deleteAtv(Serializable atv_id) throws Exception;
	
	public PageUtil<Cst_customer> findCstPage(int curpage,int row) throws Exception;
	
	//public Set<Orders> findOrderByCustId(Serializable cust_id) throws Exception;
	
	public Orders findOrderById(Serializable id) throws Exception;
	
	public PageUtil<Cst_customer> findCstPageByCon(int curpage,int row,Condition con) throws Exception;

	public void saveLoster() throws Exception;
	
	public List<Cst_lost> findLoster() throws Exception ;
	
	public Cst_lost findLosterById(Serializable lostId) throws Exception;
	
	public void updateLost(Cst_lost lost) throws Exception;
}
