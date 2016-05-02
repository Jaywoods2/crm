package cn.zk.entity;

import java.io.Serializable;
import java.util.Date;

public class Salplan implements Serializable{
   private int pla_id;
   private int pla_chc_id;
   private Date pla_date;
   private String pla_todo;
   private String pla_result;
   public Salplan(){}
   
public int getPla_id() {
	return pla_id;
}

public void setPla_id(int plaId) {
	pla_id = plaId;
}

public int getPla_chc_id() {
	return pla_chc_id;
}
public void setPla_chc_id(int plaChcId) {
	pla_chc_id = plaChcId;
}

public Date getPla_date() {
	return pla_date;
}
public void setPla_date(Date plaDate) {
	pla_date = plaDate;
}
public String getPla_todo() {
	return pla_todo;
}
public void setPla_todo(String plaTodo) {
	pla_todo = plaTodo;
}
public String getPla_result() {
	return pla_result;
}
public void setPla_result(String plaResult) {
	pla_result = plaResult;
}
   
}
