package cn.zk.entity;

import java.io.Serializable;

public class Product implements Serializable {
private int prod_id;
private String prod_name;
private String prod_type;
private String prod_batch;
private String prod_unit;
private float prod_price;
private String prod_memo;
public Product(){}
public int getProd_id() {
	return prod_id;
}
public void setProd_id(int prodId) {
	prod_id = prodId;
}
public String getProd_name() {
	return prod_name;
}
public void setProd_name(String prodName) {
	prod_name = prodName;
}
public String getProd_type() {
	return prod_type;
}
public void setProd_type(String prodType) {
	prod_type = prodType;
}
public String getProd_batch() {
	return prod_batch;
}
public void setProd_batch(String prodBatch) {
	prod_batch = prodBatch;
}
public String getProd_unit() {
	return prod_unit;
}
public void setProd_unit(String prodUnit) {
	prod_unit = prodUnit;
}
public float getProd_price() {
	return prod_price;
}
public void setProd_price(float prodPrice) {
	prod_price = prodPrice;
}
public String getProd_memo() {
	return prod_memo;
}
public void setProd_memo(String prodMemo) {
	prod_memo = prodMemo;
}

}
