package cn.zk.service;

import java.io.Serializable;
import java.util.List;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Salchance;
import cn.zk.entity.Salplan;
import cn.zk.util.PageUtil;

public interface SalchanceService {
	 public void saveChanceService(Salchance sc);
	 public void saveCustomerService(Cst_customer cc);
	 
	 public PageUtil<Salchance> findSalchanceByPageService(int curpage,int row);
	 public PageUtil<Salchance> findSalplanByPageService(int curpage,int row);
	 public void updateChanceService(Salchance sc);
	 public Salchance findOneSalchance(Serializable chc_id);
	 public void deleteSalchance(Serializable chc_id);
	 
	 public void savePlanService(Salplan sp);
	 public void deleteSalplanService(Serializable pla_id);
	 public void updateSalplanService(Salplan sp);
	 public PageUtil<Salchance> findSalPageByCon(int curpage,int row,Salchance sc);
	 public PageUtil<Salchance> findSalPageByConn(int curpage,int row,Salchance sc);
	 public int findUsr_idByName(String name);
}
