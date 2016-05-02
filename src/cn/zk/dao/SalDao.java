package cn.zk.dao;

import java.io.Serializable;
import java.util.List;

import cn.zk.entity.Cst_customer;
import cn.zk.entity.Salchance;
import cn.zk.entity.Salplan;
import cn.zk.util.PageUtil;

public interface SalDao {
	 public void saveChance(Salchance sc);
	 public void saveCustomer(Cst_customer cc);
	 
	 public PageUtil<Salchance> findSalchanceByPage(int curPage,int row);
	 public PageUtil<Salchance> findSalplanByPage(int curPage,int row);
	 public Salchance queryOneSalchance(Serializable chc_id);
	 public void updatechance(Salchance sc);
	 public void deleteSalchance(Serializable chc_id);
	 
	 public void savePlan(Salplan sp);
	 public void deleteSalplan(Serializable pla_id);
	 public void updateSalplan(Salplan sp);
	 
	 public PageUtil<Salchance> querySalPageByCon
	 (int curpage,int row,Salchance sc);
	 public PageUtil<Salchance> querySalPageByConn
	 (int curpage,int row,Salchance sc);
	 
	 public int getUsr_idByName(String name);
}
