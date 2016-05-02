package cn.zk.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.zk.entity.Condition;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_service;

public interface Cst_serviceDao {

	/*
	 * 新建服务
	 */
	public void save(Cst_service cst_service) throws Exception;

	/*
	 * 
	 */
	public List<Cst_service> findByHQLCondition(Condition con, int curPage,
			int row) throws Exception;

	/*
	 * 得到记录条数
	 */
	public int getdateRow(Condition con) throws Exception;

	/*
	 * 查询 状态“新创建”
	 */
	public List<Cst_service> findAll(int curPage, int row) throws Exception;
	
	/*
	 * 查询 状态 “已分配”
	 */
	public List<Cst_service> findByfp(int curPage, int row) throws Exception;
	
	/*
	 * 查询 状态“已处理”
	 */
	public List<Cst_service> findBycl(int curPage, int row) throws Exception;

	/*
	 * 查询状态“已归档”
	 */
	public List<Cst_service> findBygd(int curPage, int row) throws Exception;

	/*
	 * 根据服务标号删除服务信息
	 */

	public void delete(Serializable svr_id) throws Exception;

	/*
	 * 分配
	 */
	public void updateCst_serviceById(Serializable id, String svr_due_to,String svr_due_date,String svr_status)
			throws Exception;
	
	/*
	 * 根据编号查询单条服务信息
	 */
	public Cst_service queryOneByid(Serializable svr_id);
	
	/*
	 * ������
	 */
	public void updateinfo(Cst_service cst_service) throws Exception;
	
	/*
	 * 满意度
	 */
	public void Dealresult(Serializable id,String svr_result,int svr_satisfy,String svr_status) throws Exception;
	
	/*
	 * 查询所有的客户姓名
	 */
	public List<Object> findAllCus() throws Exception;
	
	/*
	 * 查询所有的用户
	 */
	public List<Object> findSys_user() throws Exception;
}
