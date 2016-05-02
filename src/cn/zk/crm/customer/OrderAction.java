package cn.zk.crm.customer;

import java.util.Iterator;
import java.util.Set;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Orders;
import cn.zk.entity.Orders_line;
import cn.zk.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private CustomerService customerService;
	private int cust_id;
	private Set<Orders> orders;
	private Cst_customer cs;
	private Orders order;
	private int odr_id;//订单id
	private Set<Orders_line> odds;
	private float allmoney=0;
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int custId) {
		cust_id = custId;
	}
	
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
	public Cst_customer getCs() {
		return cs;
	}

	public void setCs(Cst_customer cs) {
		this.cs = cs;
	}

	public int getOdr_id() {
		return odr_id;
	}

	public void setOdr_id(int odrId) {
		odr_id = odrId;
	}

	public Set<Orders_line> getOdds() {
		return odds;
	}

	public void setOdds(Set<Orders_line> odds) {
		this.odds = odds;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public float getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(float allmoney) {
		this.allmoney = allmoney;
	}
	
	//通过客户id查询所属订单
	public String list() {
		try {
		cs=	customerService.findCustomerById(cust_id);
		orders=cs.getOrders();
		/*for (Iterator iterator = orders.iterator(); iterator.hasNext();) {
			Orders o = (Orders) iterator.next();
			System.out.println(o.getOdr_id()+"--"+o.getOdr_cust_id()+"--"+o.getOdr_customer()+"--"+o.getOdr_addr());
		}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	
	//订单详情
	public String details(){
		try {
			order=customerService.findOrderById(odr_id);
			odds=order.getOdds();
			for (Iterator iterator = odds.iterator(); iterator.hasNext();) {
				Orders_line ordersLine = (Orders_line) iterator.next();
				int count=ordersLine.getOdd_count();
				float price=ordersLine.getProd_id().getProd_price();
				allmoney+=count*price;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "detail";
	}
}
