package cn.zk.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zk.dao.LogDAO;

import cn.zk.entity.Cst_log;
import cn.zk.entity.Sys_user;
import cn.zk.util.PageUtil;

public class LogDAOImpl implements LogDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addLogOne(Cst_log log) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.save(log);
	}

	public PageUtil<Cst_log> queryAllLogPage(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		PageUtil<Cst_log> pages=new PageUtil<Cst_log>();
		pages.setCurPage(curpage);
		pages.setROW(row);
		Session session=hibernateTemplate.getSessionFactory().openSession();
		int rows=session.createSQLQuery("select log_id from Cst_log").list().size();
		pages.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Cst_log.class);
		criteria.addOrder(Property.forName("log_date").desc());
		List<Cst_log> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		pages.setData(ss);
		return pages;
	}

	public List<Cst_log> getAllLog() throws Exception {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Cst_log.class);
		criteria.addOrder(Property.forName("log_date").desc());
		return	hibernateTemplate.findByCriteria(criteria);
		 
		 
	}
	
}
