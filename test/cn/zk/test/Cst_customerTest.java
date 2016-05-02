package cn.zk.test;


import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zk.daoimpl.JfreeDAOImpl;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Orders;
import cn.zk.entity.Orders_line;
import cn.zk.util.HibernateSessionFactory;
import junit.framework.TestCase;

public class Cst_customerTest extends TestCase {
	public void testOne(){
		
			Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	public void testTwo(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public void testThree(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try {
			//Orders od=(Orders)session.get(Orders.class, 1);
			Cst_customer s=(Cst_customer)session.get(Cst_customer.class, 1);
			System.out.println("..");
			Set<Orders> odOrders=s.getOrders();
			for (Iterator iterator = odOrders.iterator(); iterator.hasNext();) {
				Orders orders = (Orders) iterator.next();
				System.out.println(orders.getOdr_customer()+"--"+orders.getOdr_id());
			}
		System.out.println("..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public void testFour(){
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try {
			Orders o=(Orders)session.get(Orders.class, 1);
			Set<Orders_line> odds=o.getOdds();
			System.out.println(odds.size());
			for (Iterator iterator = odds.iterator(); iterator.hasNext();) {
				Orders_line ordersLine = (Orders_line) iterator.next();
				System.out.println("------");
				int count=ordersLine.getOdd_count();
				float price=ordersLine.getProd_id().getProd_price();
				float money=count*price;
				System.out.println("产品编号："+ordersLine.getProd_id().getProd_id()+"--"+ordersLine.getProd_id().getProd_name()+"总金额："+money);
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	public void testFive(){
		/*try {
			new JfreeDAOImpl().CstMakeup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
