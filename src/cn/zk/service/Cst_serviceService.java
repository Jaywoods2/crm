package cn.zk.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.zk.entity.Condition;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_service;

public interface Cst_serviceService {

	public void save(Cst_service cst_service) throws Exception;

	/*
	 * ͨ��������ѯ������Ϣ �ҷ�ҳ
	 */
	public List<Cst_service> findByHQLCondition(Condition con, int curPage,
			int row) throws Exception;

	/*
	 * �õ���ѯ��¼����������
	 */
	public int getdateRow(Condition con) throws Exception;

	/*
	 * ��ѯ����  svr_status='�´���'
	 */
	
	public List<Cst_service> findAll(int curPage, int row) throws Exception;

	/*
	 * ��ѯ����  svr_status='�ѷ���'
	 */
	
	public List<Cst_service> findByfp(int curPage, int row) throws Exception;

	/*
	 * ��ѯ����  svr_status='�Ѵ���'
	 */
	public List<Cst_service> findBycl(int curPage, int row) throws Exception;
	
	/*
	 * ͨ�������ɾ��ǰ������Ϣ
	 */

	public void delete(Serializable svr_id) throws Exception;

	/*
	 * ָ������
	 */
	public void updateCst_serviceById(Serializable id, String svr_due_to,String svr_due_date,String svr_status)
			throws Exception;
	
	/*
	 * ��ݷ����Ų�ѯ
	 */
	public Cst_service queryOneByid(Serializable svr_id);
	
	/*
	 * ������
	 */
	public void updateinfo(Cst_service cst_service) throws Exception;
	
	/*
	 * ������
	 */
	public void Dealresult(Serializable id,String svr_result,int svr_satisfy,String svr_status) throws Exception;
	
	/*
	 * ��ѯ����  svr_status='�� �鵵'
	 */
	public List<Cst_service> findBygd(int curPage, int row) throws Exception;

	/*
	 * 查询所有的客户姓名
	 */
	public List<Object> findAllCus() throws Exception;
	
	/*
	 * 查询所有的用户
	 */
	public List<Object> findSys_user() throws Exception;

}
