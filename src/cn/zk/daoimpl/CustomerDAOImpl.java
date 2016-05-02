package cn.zk.daoimpl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zk.crm.customer.Condition;
import cn.zk.dao.CustomerDAO;
import cn.zk.entity.Cst_activity;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Cst_linkman;
import cn.zk.entity.Cst_lost;
import cn.zk.entity.Orders;
import cn.zk.util.PageUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Cst_customer> allCustomer() throws Exception {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Cst_customer");
	}

	public List<Cst_customer> customerPage(int curpage, int row)
			throws Exception {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Cst_customer.class);
		List<Cst_customer> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		return ss;
	}
	
	public PageUtil<Cst_customer> queryCstPage(int curpage,int row) throws Exception{
		PageUtil<Cst_customer> page=new PageUtil<Cst_customer>();
		page.ROW=row;
		page.setCurPage(curpage);
		int rows=hibernateTemplate.find("from Cst_customer").size();
		page.setRows(rows);
		DetachedCriteria criteria=DetachedCriteria.forClass(Cst_customer.class);
		List<Cst_customer> ss=hibernateTemplate.findByCriteria(criteria, (curpage-1)*row, row);
		page.setData(ss);
		return page;
	}

	public Cst_customer queryCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		Cst_customer cus=(Cst_customer) hibernateTemplate.get(Cst_customer.class, id);
		return cus;
	}

	public void updateCustomer(Cst_customer c) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(c);
	}

	public void addLinkMan(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.save(lkm);
	}

	public void deleteLinkMan(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		Cst_linkman lm=	(Cst_linkman) hibernateTemplate.get(Cst_linkman.class, id);
		hibernateTemplate.delete(lm);
	}

	public Cst_linkman queryLinkmanById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		Cst_linkman lm=	(Cst_linkman) hibernateTemplate.get(Cst_linkman.class, id);
		return lm;
	}

	public void updateLinkman(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(lkm);
	}

	public void delCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		Cst_customer cs=(Cst_customer)hibernateTemplate.get(Cst_customer.class, id);
		hibernateTemplate.delete(cs);
	}

	public void addCst_activity(Cst_activity av) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.save(av);
	}

	public Cst_activity queryAtvById(Serializable atv_id) throws Exception {
		// TODO Auto-generated method stub
		return (Cst_activity) hibernateTemplate.get(Cst_activity.class, atv_id);
	}

	public void updateAtv(Cst_activity at) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(at);
	}

	public void deleteAtv(Serializable atvId) throws Exception {
		// TODO Auto-generated method stub
		Cst_activity ac=(Cst_activity) hibernateTemplate.get(Cst_activity.class, atvId);
		hibernateTemplate.delete(ac);
	}

	public Orders queryOrderById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return (Orders) hibernateTemplate.get(Orders.class, id);
	}

	public PageUtil<Cst_customer> queryCstPageByCon(int curpage, int row,
			Condition con) throws Exception {
		// TODO Auto-generated method stub
		String hql="from Cst_customer where 1=1";
		if(con!=null){
		if(con.getCust_no()!=null){
			hql+=" and cust_no='"+con.getCust_no()+"'";
		}
		if(con.getCust_name()!=null){
			hql+=" and cust_name='"+con.getCust_name()+"'";
		}
		if(con.getCust_addr()!=null){
			hql+=" and cust_region='"+con.getCust_addr()+"'";
		}
		if(con.getCust_manager_name()!=null){
			hql+=" and cust_manager_name='"+con.getCust_manager_name()+"'";
		}
		if(con.getCust_level_label()!=null){
			hql+=" and cust_level_label='"+con.getCust_level_label()+"'";
		}}
		//System.out.println(hql);
		
		PageUtil<Cst_customer> page=new PageUtil<Cst_customer>();
		page.ROW=row;
		page.setCurPage(curpage);
		List<Cst_customer> ss=hibernateTemplate.find(hql);
		int rows=ss.size();
		page.setRows(rows);
		List<Cst_customer> s2=new ArrayList<Cst_customer>();
		
		Iterator iterator = ss.iterator();
		for(int i=0;i<(curpage-1)*row;i++){
			if(iterator.hasNext()){
				iterator.next();
			}
		}
		for(int j=0;j<row;j++){
			if(iterator.hasNext()){
				s2.add((Cst_customer)iterator.next());
			}
		}
		
		page.setData(s2);
		return page;
	}

	public void insertLoster() throws Exception {
		// TODO Auto-generated method stub
		String sql="select odr_cust_id,max(odr_date) from orders group by odr_cust_id";
		Session session=hibernateTemplate.getSessionFactory().openSession();
		List<Object> allodr=session.createSQLQuery(sql).list();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<allodr.size();i++){
			Object[] a=(Object[]) allodr.get(i);
			int cust_id=Integer.parseInt(a[0].toString());
			//求时间差
			String date=a[1].toString();
			Date d2=format.parse(date);
			Date d1=new Date();
			long diff=d1.getTime()-d2.getTime();
			long days=diff / (1000 * 60 * 60 * 24); 
			if(days/30>6){
				//超过6个月，代表已流失；
				//判断该流失是否已经存在
				int siz=hibernateTemplate.find("from Cst_lost where lost_cust_id="+cust_id).size();
				if(siz==0){	
				Cst_lost lost=new Cst_lost();
				Cst_customer cst=(Cst_customer) hibernateTemplate.get(Cst_customer.class, cust_id);
				lost.setLost_cust_id(cust_id);
				lost.setLost_cust_name(cst.getCust_name());
				lost.setLost_mgr(cst.getCust_manager_name());
				lost.setLost_last_odrdate(date);
				lost.setLost_statue(0);//0代表暂缓流失
				lost.setLost_step("打电话给客户了解不再购买本公司产品的原因。发送新产品目录给客户。 ");
				hibernateTemplate.save(lost);//添加流失记录
				cst.setCust_status('0');//将客户状态设为不正常
				hibernateTemplate.update(cst);}
			}
			
		}
	}

	
	public List<Cst_lost> getLoster() throws Exception {
		// TODO Auto-generated method stub
		return	hibernateTemplate.find("from Cst_lost"); 
	}

	public Cst_lost getLosterById(Serializable lostId) throws Exception {
		// TODO Auto-generated method stub
		return (Cst_lost) hibernateTemplate.get(Cst_lost.class, lostId);
	}

	public void updateLost(Cst_lost lost) throws Exception {
		// TODO Auto-generated method stub
		hibernateTemplate.update(lost);
	}

	

	

	
}
