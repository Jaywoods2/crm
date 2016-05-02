package cn.zk.entity;

import java.io.Serializable;
import java.util.Date;

public class Cst_log implements Serializable{
	private int log_id;
	private String log_op;
	private String log_event;
	private Date log_date;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int logId) {
		log_id = logId;
	}
	public String getLog_op() {
		return log_op;
	}
	public void setLog_op(String logOp) {
		log_op = logOp;
	}
	public String getLog_event() {
		return log_event;
	}
	public void setLog_event(String logEvent) {
		log_event = logEvent;
	}
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date logDate) {
		log_date = logDate;
	}
	
}
