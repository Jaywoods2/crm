package cn.zk.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Salchance;
import cn.zk.entity.Salplan;
import cn.zk.util.HibernateSessionFactory;
import cn.zk.util.PageUtil;

public class SalDaoimpl implements cn.zk.dao.SalDao {
   private HibernateTemplate hibernateTemplate;
   
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

	public void saveChance(Salchance sc) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(sc);
	}

	public PageUtil<Salchance> findSalchanceByPage(final int curpage, final int row) {
		PageUtil<Salchance> page=new PageUtil<Salchance>();
		page.ROW=row;
		page.setCurPage(curpage);
		int rows=hibernateTemplate.find("from Salchance s where s.chc_status='未分配'").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Salchance.class);
		criteria.add(Restrictions.eq("chc_status", "未分配"));
		List<Salchance> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		page.setData(ss);
		return page;
		/*
		List<Salchance> sc=(List<Salchance>) hibernateTemplate.execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				List<Salchance> t=null;
				Query query=session.createQuery("from Salchance");
				query.setFirstResult((curPage-1)*row);
				query.setMaxResults(row);
				t=query.list();
				return t;
			}
		});
		return sc;*/
	}
	public PageUtil<Salchance> findSalplanByPage(final int curpage, final int row) {
		PageUtil<Salchance> page=new PageUtil<Salchance>();
		page.ROW=row;
		page.setCurPage(curpage);
		int rows=hibernateTemplate.find("from Salchance s where s.chc_status<>'未分配'").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Salchance.class);
		
		//criteria.add(Restrictions.like("chc_status", "开发中"));
		//criteria.add(Restrictions.eq("chc_status", "已归档"));
		List<Salchance> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		page.setData(ss);
		return page;
	}
	public void updatechance(Salchance sc) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(sc);
	}

	public Salchance queryOneSalchance(Serializable chc_id) {
		// TODO Auto-generated method stub
		return (Salchance) hibernateTemplate.load(Salchance.class, chc_id);
	}

	public void deleteSalchance(Serializable chc_id) {
		// TODO Auto-generated method stub
		Salchance sc=(Salchance)hibernateTemplate.get(Salchance.class, chc_id);
		hibernateTemplate.delete(sc);	
	}

	public void savePlan(Salplan sp) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(sp);
	}

	public void deleteSalplan(Serializable pla_id) {
		// TODO Auto-generated method stub
		Salplan sp=(Salplan)hibernateTemplate.get(Salplan.class, pla_id);
		
		hibernateTemplate.delete(sp);
	}

	public void updateSalplan(Salplan sp) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(sp);
	}

	public PageUtil<Salchance> querySalPageByCon(int curpage, int row,Salchance sc) {
		//Session session=HibernateSessionFactory.getSession();
		//Transaction tx=session.beginTransaction();
		PageUtil<Salchance> page=new PageUtil<Salchance>();
		page.ROW=row;
		page.setCurPage(curpage);
		int rows=hibernateTemplate.find("from Salchance s where s.chc_status='未分配'").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Salchance.class);
		criteria.add(Restrictions.eq("chc_status", "未分配"));
		//try{
		if(sc.getChc_cust_name()!=null){
			
			Criterion a=Restrictions.like("chc_cust_name", "%"+sc.getChc_cust_name()+"%");
			criteria.add(a);
		}
			if(sc.getChc_cust_name()!=null){
				
				Criterion a=Restrictions.like("chc_cust_name", "%"+sc.getChc_cust_name()+"%");
				criteria.add(a);
			}
			if(sc.getChc_title()!=null){
				
				Criterion b=Restrictions.like("chc_title", "%"+sc.getChc_title()+"%");
				criteria.add(b);
			}
			if(sc.getChc_linkman()!=null){
				
				Criterion c=Restrictions.like("chc_linkman", "%"+sc.getChc_linkman()+"%");
				criteria.add(c);
			}
			//tx.commit();
		//}catch(Exception ex){
			//ex.printStackTrace();
			//tx.rollback();
		//}finally{
		//	HibernateSessionFactory.closeSession();
		//}
		List<Salchance> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		page.setData(ss);
		return page;
		// TODO Auto-generated method stub
		/*String hql="from sal_chance c where 1=1";
		if(sc!=null){
		if(sc.getChc_cust_name()!=null){
			hql+=" and c='"+sc.getChc_cust_name()+"'"; 
		}
		if(sc.getChc_title()!=null){
			hql+=" and c='"+sc.getChc_title()+"'";
		}
		if(sc.getChc_linkman()!=null){
			hql+=" and c='"+sc.getChc_linkman()+"'";
		}
		}
		//System.out.println(hql);
		
		PageUtil<Salchance> page=new PageUtil<Salchance>();
		page.ROW=row;
		page.setCurPage(curpage);
		List<Salchance> ss=hibernateTemplate.find(hql);
		int rows=ss.size();
		page.setRows(rows);
		List<Salchance> s2=new ArrayList<Salchance>();
		
		Iterator iterator = ss.iterator();
		for(int i=0;i<(curpage-1)*row;i++){
			if(iterator.hasNext()){
				iterator.next();
			}
		}
		for(int j=0;j<row;j++){
			if(iterator.hasNext()){
				s2.add((Salchance)iterator.next());
			}
		}
		
		page.setData(s2);
		return page;*/
	}

	public void saveCustomer(Cst_customer cc) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(cc);
	}

	public PageUtil<Salchance> querySalPageByConn(int curpage, int row,
			Salchance sc) {
		// TODO Auto-generated method stub
		PageUtil<Salchance> page=new PageUtil<Salchance>();
		page.ROW=row;
		page.setCurPage(curpage);
		int rows=hibernateTemplate.find("from Salchance s where s.chc_status<>'未分配'").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Salchance.class);
		
		//try{
			
			if(sc.getChc_cust_name()!=null){
				
				Criterion a=Restrictions.like("chc_cust_name", "%"+sc.getChc_cust_name()+"%");
				criteria.add(a);
			}
			if(sc.getChc_title()!=null){
				
				Criterion b=Restrictions.like("chc_title", "%"+sc.getChc_title()+"%");
				criteria.add(b);
			}
			if(sc.getChc_linkman()!=null){
				
				Criterion c=Restrictions.like("chc_linkman", "%"+sc.getChc_linkman()+"%");
				criteria.add(c);
			}
			//tx.commit();
		//}catch(Exception ex){
			//ex.printStackTrace();
			//tx.rollback();
		//}finally{
		//	HibernateSessionFactory.closeSession();
		//}
		List<Salchance> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		page.setData(ss);
		return page;
	}

	public int getUsr_idByName(String name) {
		// TODO Auto-generated method stub
		String sql="select usr_id from sys_user where usr_name='"+name+"'";
	Session session=	hibernateTemplate.getSessionFactory().openSession();
	List<Object> mgr=session.createSQLQuery(sql).list();
	if(mgr.size()!=0){
	Object a=	(Object) mgr.get(0);
	return Integer.parseInt(a.toString());
	}
	return 0;
	}
}
