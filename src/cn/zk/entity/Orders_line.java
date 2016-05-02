package cn.zk.entity;

import java.io.Serializable;

//订单中的某一条
public class Orders_line implements Serializable {
	private int odd_id;
	private Orders odd_order_id;
	private Product prod_id;// 产品
	private int odd_count;// 总数量

	public Orders_line() {
	}

	public int getOdd_id() {
		return odd_id;
	}

	public void setOdd_id(int oddId) {
		odd_id = oddId;
	}

	public Orders getOdd_order_id() {
		return odd_order_id;
	}

	public void setOdd_order_id(Orders oddOrderId) {
		odd_order_id = oddOrderId;
	}

	public Product getProd_id() {
		return prod_id;
	}

	public void setProd_id(Product prodId) {
		prod_id = prodId;
	}

	public int getOdd_count() {
		return odd_count;
	}

	public void setOdd_count(int oddCount) {
		odd_count = oddCount;
	}

}
