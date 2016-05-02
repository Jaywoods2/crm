package cn.zk.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

import cn.zk.basd.Dict;
import cn.zk.dao.DictDao;
import cn.zk.util.PageUtil;




public class DictDAOImpl implements DictDao {
	private HibernateTemplate hibernateTemplate;
	 
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

	public PageUtil<Dict> findPersonByPage(final int curPage, final int row) {
		// TODO Auto-generated method stub
		PageUtil<Dict> page=new PageUtil<Dict>();
		page.ROW=row;
		page.setCurPage(curPage);
		int rows=hibernateTemplate.find("from Dict").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Dict.class);
		List<Dict> ss=hibernateTemplate.findByCriteria(criteria, (curPage-1)*row, row);
		page.setData(ss);
		return page;
	}

	public void savePerson(Dict p) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(p);
	}

	public void updatePerson(Dict p) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(p);
	}
	
	public Dict queryOneSalchance(Serializable dict_id) {
		// TODO Auto-generated method stub
		//Dict_add d=(Dict_add) hibernateTemplate.load(Dict_add.class, bh);
		return (Dict) hibernateTemplate.load(Dict.class, dict_id);
	}
	public void deletePerson(Serializable dict_id) {
		// TODO Auto-generated method stub
		Dict tt=(Dict) hibernateTemplate.get(Dict.class, dict_id);
		hibernateTemplate.delete(tt);
	}

}
