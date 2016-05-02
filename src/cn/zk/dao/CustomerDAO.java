package cn.zk.dao;

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



public interface CustomerDAO {
	public List<Cst_customer> allCustomer() throws Exception;
	public List<Cst_customer> customerPage(int curpage,int row) throws Exception;
	public Cst_customer queryCustomerById(Serializable id)throws Exception;
	public void updateCustomer(Cst_customer c) throws Exception;
	public void addLinkMan(Cst_linkman lkm) throws Exception;
	public void deleteLinkMan(Serializable id) throws Exception;
	public Cst_linkman queryLinkmanById(Serializable id) throws Exception;
	public void updateLinkman(Cst_linkman lkm) throws Exception;
	public void delCustomerById(Serializable id) throws Exception;
	public void addCst_activity(Cst_activity av) throws Exception;
	public Cst_activity queryAtvById(Serializable atv_id) throws Exception;
	public void updateAtv(Cst_activity at) throws Exception;
	public void deleteAtv(Serializable atv_id) throws Exception;
	public PageUtil<Cst_customer> queryCstPage(int curpage,int row) throws Exception;
	//public Set<Orders> queryOrderByCustId(Serializable cust_id) throws Exception;
	public Orders queryOrderById(Serializable id) throws Exception;
	public PageUtil<Cst_customer> queryCstPageByCon(int curpage,int row,Condition con) throws Exception;
	public void insertLoster() throws Exception;
	public List<Cst_lost> getLoster() throws Exception;
	public Cst_lost getLosterById(Serializable lost_id) throws Exception;
	public void  updateLost(Cst_lost lost) throws Exception;
}
