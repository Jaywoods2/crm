package cn.zk.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zk.dao.UserDAO;
import cn.zk.entity.Sys_role;
import cn.zk.entity.Sys_user;
import cn.zk.util.PageUtil;

public class UserDAOImpl implements UserDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Sys_user login(String username, String password)throws Exception {
		// TODO Auto-generated method stub
		String hql="from Sys_user where usr_name=? and usr_password=?";
		List<Sys_user> list=hibernateTemplate.find(hql,new Object[]{username,password});
		Sys_user u=null;
		if(list.size()!=0){
			u=list.get(0);
		}
		return u;
	}

	public List<Sys_user> getAllMgr() throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Sys_user where usr_role_id=3");
	}

	public List<Sys_role> getAllRole() throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Sys_role");
	}

	public Sys_role getOneRole(int role_id) throws Exception {
		// TODO Auto-generated method stub
		return (Sys_role) hibernateTemplate.get(Sys_role.class, role_id);
	}

	public void updateRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(role);
	}
	
	public PageUtil<Sys_user> getAllUser(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		PageUtil<Sys_user> pages=new PageUtil<Sys_user>();
		pages.setCurPage(curpage);
		pages.setROW(row);
		Session session=hibernateTemplate.getSessionFactory().openSession();
		int rows=session.createSQLQuery("select usr_id from Sys_user").list().size();
		pages.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Sys_user.class);
		criteria.addOrder(Property.forName("usr_id").asc());
		List<Sys_user> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		pages.setData(ss);
		return pages;
	}
	
}
