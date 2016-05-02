package cn.zk.crm.sale;

import cn.zk.entity.Salplan;
import cn.zk.service.SalchanceService;

import com.opensymphony.xwork2.ActionSupport;

public class DoplanAction extends ActionSupport{
   private Salplan sp;
   private SalchanceService salchanceService;
   private int pla_id;
   
public int getPla_id() {
	return pla_id;
}

public void setPla_id(int plaId) {
	pla_id = plaId;
}

public SalchanceService getSalchanceService() {
	return salchanceService;
}

public void setSalchanceService(SalchanceService salchanceService) {
	this.salchanceService = salchanceService;
}

public Salplan getSp() {
	return sp;
}

public void setSp(Salplan sp) {
	this.sp = sp;
}
  
/**
 * 添加计划
 * @return
 * @throws Exception
 */
public String addplan() throws Exception{
	salchanceService.savePlanService(sp);
	return "addplan";   
   }
public String deleteSalplan()throws Exception{
	salchanceService.deleteSalplanService(pla_id);
	return "deleteSalplan";
  }
public String updateSalplan() throws Exception{
	salchanceService.updateSalplanService(sp);
	return "updateSalplan";
 }
/**
 * 计划开发结果
 * @return
 * @throws Exception
 */
public String updatePlanResult() throws Exception{
	salchanceService.updateSalplanService(sp);
	return "updatePlanResult";
}

}
