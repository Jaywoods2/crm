package cn.zk.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.orm.hibernate3.HibernateTemplate;
import cn.zk.dao.JfreeDAO;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Orders;
import cn.zk.entity.Orders_line;

public class JfreeDAOImpl implements JfreeDAO {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public CategoryDataset Cstcontribute(String name,String year) throws Exception {
		// TODO Auto-generated method stub
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	
			if((name==null||name.length()==0)&&(year==null||"".equals(year))){
			List<Cst_customer> csts=hibernateTemplate.find("from Cst_customer");
			for (Iterator cit = csts.iterator(); cit.hasNext();) {
				Cst_customer cst= (Cst_customer) cit.next();
				String cust_name=cst.getCust_name();
				
				float sum=0;
				Set<Orders> ods=cst.getOrders();
				for (Iterator odsit = ods.iterator(); odsit.hasNext();) {
					Orders order= (Orders) odsit.next();					
					Set<Orders_line> odds=order.getOdds();
						for (Iterator oddit = odds.iterator(); oddit.hasNext();) {
							Orders_line ordersLine = (Orders_line) oddit.next();
							sum+=ordersLine.getOdd_count()*ordersLine.getProd_id().getProd_price();
						
						}	}
				dataset.addValue(sum, "客户贡献", cust_name);
				}}
			//---------------------------------------------------
			else if(name!=null&&(year!=null)&&"".equals(year)){
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
				List<Cst_customer> csts=hibernateTemplate.find("from Cst_customer");
				for (Iterator cit = csts.iterator(); cit.hasNext();) {
					Cst_customer cst= (Cst_customer) cit.next();
					String cust_name=cst.getCust_name();
					if(cust_name.contains(name)){
					
					Set<Orders> ods=cst.getOrders();
					for (Iterator odsit = ods.iterator(); odsit.hasNext();) {
						float sum=0;
						Orders order= (Orders) odsit.next();		
						Set<Orders_line> odds=order.getOdds();
							for (Iterator oddit = odds.iterator(); oddit.hasNext();) {
								Orders_line ordersLine = (Orders_line) oddit.next();
								sum+=ordersLine.getOdd_count()*ordersLine.getProd_id().getProd_price();
							
							}	
							dataset.addValue(sum, "客户贡献", order.getOdr_date());}
						
					}
					}
			}
			//---------------------------------------------------
			else if((year!=null)&&(name!=null&&"".equals(name))){
				String hql="from Orders";
				List<Orders> list=hibernateTemplate.find(hql);
				System.out.println(",,");
				List<Orders> orders=new ArrayList<Orders>();
				for(int j=0;j<list.size();j++){
					Orders od=list.get(j);
					if(od.getOdr_date().contains(year)){
						orders.add(od);
					}
				}
				for (Iterator iterator = orders.iterator(); iterator.hasNext();) {
					Orders order = (Orders) iterator.next();
				int odr_cust_id=	order.getOdr_cust_id();
				Session session=hibernateTemplate.getSessionFactory().openSession();
				SQLQuery sqlquery=session.createSQLQuery("select cust_name from Cst_customer where cust_id="+odr_cust_id);
				List<Object> l=sqlquery.list();
				Object a=(Object) l.get(0);
				String curt_name=a.toString();
				Set<Orders_line> oddline=order.getOdds();
				float sum=0;
				for (Iterator iterator2 = oddline.iterator(); iterator2
						.hasNext();) {
					Orders_line ordersLine = (Orders_line) iterator2.next();
					sum+=ordersLine.getProd_id().getProd_price()*ordersLine.getOdd_count();
				}
				dataset.setValue(sum,"总金额",curt_name);
			
			}
			
			}return dataset;
	}
	
	public CategoryDataset CstMakeup(int condit) throws Exception{
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		Session session=hibernateTemplate.getSessionFactory().openSession();
		
		if(condit==0){	
			String sql="select cust_id from  cst_customer";
			SQLQuery  sqlquery2=session.createSQLQuery(sql);
		float sum=sqlquery2.list().size();
		String hql="select cust_level_label name,count(*) count from cst_customer group by  cust_level_label";						
		SQLQuery  sqlquery=session.createSQLQuery(hql);		
		List<Object> l=sqlquery.list(); 
		for(int i=0;i<l.size();i++){
			Object[] a=(Object[]) l.get(i);
			//System.out.println(a[0].toString()+"--"+Integer.parseInt(a[1].toString())/sum);
			dataset.setValue(Integer.parseInt(a[1].toString())/sum,"客户等级百分比",a[0].toString());
			}
		}
		else if(condit==1){
			String hql="select cust_level_label name,sum(cust_credit) sum ,5*count(*) count from cst_customer group by  cust_level_label";
			SQLQuery  sqlquery=session.createSQLQuery(hql);		
			List<Object> l=sqlquery.list(); 
			for(int i=0;i<l.size();i++){
				Object[] a=(Object[]) l.get(i);
				dataset.setValue(Float.parseFloat(a[1].toString())/Float.parseFloat(a[2].toString()),"客户信誉百分比",a[0].toString());
				}
		}
		else if(condit==2){
			String hql="select cust_level_label name,sum(cust_satisfy) count from cst_customer group by  cust_level_label";
			SQLQuery  sqlquery=session.createSQLQuery(hql);		
			List<Object> l=sqlquery.list(); 
			for(int i=0;i<l.size();i++){
				Object[] a=(Object[]) l.get(i);
				//System.out.println(a[0].toString()+"--"+Integer.parseInt(a[1].toString())/sum);
				dataset.setValue(Float.parseFloat(a[1].toString())/Float.parseFloat(a[2].toString()),"客户信誉百分比",a[0].toString());
				}
		}
		return dataset;
	}

	public CategoryDataset CstService(String year) throws Exception {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		String sql="select svr_type type ,count(svr_type) count from cst_service where 1=1";
		if(year!=null){
			sql+=" and svr_create_date like '"+year+"%'";
		}
		sql+=" group by  svr_type";
		Session session=	hibernateTemplate.getSessionFactory().openSession();
		SQLQuery sqlquery=session.createSQLQuery(sql);
		List<Object> list=sqlquery.list();
		for(int i=0;i<list.size();i++){
			Object[] sev=(Object[]) list.get(i);
			dataset.setValue(Integer.parseInt(sev[1].toString()), "服务类型", sev[0].toString());
		}
		return dataset;
	}
}
