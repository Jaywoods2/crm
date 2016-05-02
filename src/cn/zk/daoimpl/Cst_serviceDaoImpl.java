package cn.zk.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zk.dao.Cst_serviceDao;
import cn.zk.entity.Condition;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_service;
import cn.zk.util.HibernateSessionFactory;

public class Cst_serviceDaoImpl implements Cst_serviceDao {

	private HibernateTemplate hibernateTemplate;
	private Cst_service cst_service;
	private Condition con;

	public Cst_service getCst_service() {
		return cst_service;
	}

	public void setCst_service(Cst_service cstService) {
		cst_service = cstService;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Cst_service cst_service) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(cst_service);
	}

	public Condition getCon() {
		return con;
	}

	public void setCon(Condition con) {
		this.con = con;
	}

	public List<Cst_service> findByHQLCondition(Condition con, int curPage,
			int row) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		List<Cst_service> res = null;
		try {
			String hql = "from Cst_service c where 1=1 ";
			if (con.getSvr_cust_name() != null
					&& !"".equals(con.getSvr_cust_name())) {
				if ("GET".equals(ServletActionContext.getRequest().getMethod())) {
					con.setSvr_cust_name(new String(con.getSvr_cust_name()
							.getBytes("iso-8859-1"), "utf-8"));
				}
				hql += " and (c.svr_cust_name='" + con.getSvr_cust_name()
						+ "')";
			}
			if (con.getSvr_title() != null && !"".equals(con.getSvr_title())) {
				if ("GET".equals(ServletActionContext.getRequest().getMethod())) {
					con.setSvr_title(new String(con.getSvr_title().getBytes(
							"iso-8859-1"), "utf-8"));
				}
				hql += " and (c.svr_title='" + con.getSvr_title() + "')";
			}
			if (con.getSvr_type() != null && !"".equals(con.getSvr_type())) {
				if ("GET".equals(ServletActionContext.getRequest().getMethod())) {
					con.setSvr_type(new String(con.getSvr_type().getBytes(
							"iso-8859-1"), "utf-8"));
				}
				hql += " and (c.svr_type='" + con.getSvr_type() + "')";
			}
			if (con.getMindate() != null && con.getMaxdate() != null
					&& !"".equals(con.getMaxdate())) {
				/*
				 * hql += " and (c.svr_create_date between  to_date('" +
				 * con.getMindate() + "','yyyy-MM-dd HH-MM-SS') and to_date('" +
				 * con.getMaxdate() + "','yyyy-MM-dd HH-MM-SS'))";
				 */
				hql += " and (c.svr_create_date between ('" + con.getMindate()
						+ "') and ('" + con.getMaxdate() + "'))";
			}
			if (con.getSvr_status() != null && !"".equals(con.getSvr_status())) {
				if ("GET".equals(ServletActionContext.getRequest().getMethod())) {
					con.setSvr_status(new String(con.getSvr_status().getBytes(
							"iso-8859-1"), "utf-8"));
				}
				hql += " and (c.svr_status='" + con.getSvr_status() + "')";
			}
			Query query = session.createQuery(hql);
			query.setFirstResult((curPage - 1) * row);
			query.setMaxResults(row);
			res = query.list();
			if (res != null) {
				for (Cst_service cst_service : res) {
					ServletActionContext.getRequest().setAttribute("res", res);
				}
			}
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return res;
	}

	public int getdateRow(Condition con) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "SELECT COUNT(*) FROM Cst_service cst";
			Query query = session.createQuery(hql);
			tx.commit();
			return ((Long) query.uniqueResult()).intValue();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return 0;
	}

	public List<Cst_service> findAll(int curPage, int row) throws Exception {

		return hibernateTemplate.find(
				"from Cst_service s where s.svr_status=?", "新创建");
	}

	public void delete(Serializable svr_id) throws Exception {
		// TODO Auto-generated method stub
		Object id = hibernateTemplate.get(Cst_service.class, svr_id);
		if (id != null) {
			hibernateTemplate.delete(id);
		}
	}

	public void update(Cst_service cs) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(cs);
	}

	public void updateCst_serviceById(Serializable id, String svr_due_to,
			String svr_due_date, String svr_status) throws Exception {
		// TODO Auto-generated method stub
		Cst_service svr = (Cst_service) hibernateTemplate.get(
				Cst_service.class, id);
		svr.setSvr_due_to(svr_due_to);
		svr.setSvr_due_date(svr_due_date);
		svr.setSvr_status(svr_status);
		hibernateTemplate.update(svr);
	}

	public Cst_service queryOneByid(Serializable svr_id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Cst_service cst = null;
		if (svr_id != null) {
			try {
				cst = (Cst_service) session.get(Cst_service.class, svr_id);
				if (cst != null) {
					ServletActionContext.getRequest().setAttribute("cst", cst);
				}
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				HibernateSessionFactory.closeSession();
			}
		}
		return cst;
	}

	public void updateinfo(Cst_service cst_service) throws Exception {
		// TODO Auto-generated method stub
		Cst_service c = (Cst_service) hibernateTemplate.get(Cst_service.class,
				cst_service.getSvr_id());
		c.setSvr_deal(cst_service.getSvr_deal());
		c.setSvr_deal_date(cst_service.getSvr_deal_date());
		c.setSvr_status(cst_service.getSvr_status());
		hibernateTemplate.update(c);
	}

	public void Dealresult(Serializable id, String svr_result, int svr_satisfy,
			String svr_status) throws Exception {
		// TODO Auto-generated method stub
		Cst_service svr = (Cst_service) hibernateTemplate.get(
				Cst_service.class, id);
		svr.setSvr_result(svr_result);
		svr.setSvr_satisfy(svr_satisfy);
		svr.setSvr_status(svr_status);
		hibernateTemplate.update(svr);
	}

	public List<Cst_service> findByfp(int curPage, int row) throws Exception {

		return hibernateTemplate.find(
				"from Cst_service s where s.svr_status=?", "已分配");
	}

	public List<Cst_service> findBycl(int curPage, int row) throws Exception {

		return hibernateTemplate.find(
				"from Cst_service s where s.svr_status=?", "已处理");
	}

	public List<Cst_service> findBygd(int curPage, int row) throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find(
				"from Cst_service s where s.svr_status=?", "已归档");
	}

	public List<Object> findAllCus() throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select c.cust_name from Cst_customer c");
	}

	public List<Object> findSys_user() throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select s.usr_name from Sys_user s");
	}

}
