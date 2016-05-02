package cn.zk.serviceimpl;

import java.io.Serializable;
import java.util.List;

import cn.zk.dao.SalDao;
import cn.zk.entity.Cst_customer;
import cn.zk.entity.Salchance;
import cn.zk.entity.Salplan;
import cn.zk.service.SalchanceService;
import cn.zk.util.PageUtil;

public class SalchanceServiceimpl implements SalchanceService {
    private SalDao saldao;
    
	public SalDao getSaldao() {
		return saldao;
	}

	public void setSaldao(SalDao saldao) {
		this.saldao = saldao;
	}

	public void saveChanceService(Salchance sc) {
		// TODO Auto-generated method stub
		saldao.saveChance(sc);
	}

	public PageUtil<Salchance> findSalchanceByPageService(int curpage, int row) {
		// TODO Auto-generated method stub
		return saldao.findSalchanceByPage(curpage, row);
	}
	public PageUtil<Salchance> findSalplanByPageService(int curpage, int row) {
		// TODO Auto-generated method stub
		return saldao.findSalplanByPage(curpage, row);
	}
	public void updateChanceService(Salchance sc) {
		// TODO Auto-generated method stub
	    saldao.updatechance(sc);
	}

	public Salchance findOneSalchance(Serializable chc_id) {
		// TODO Auto-generated method stub
		return saldao.queryOneSalchance(chc_id);
	}

	public void deleteSalchance(Serializable chc_id) {
		// TODO Auto-generated method stub
		saldao.deleteSalchance(chc_id);
	}

	
	
	public void savePlanService(Salplan sp) {
		// TODO Auto-generated method stub
		saldao.savePlan(sp);
	}

	public void deleteSalplanService(Serializable pla_id) {
		// TODO Auto-generated method stub
		saldao.deleteSalplan(pla_id);
	}
	

	public void updateSalplanService(Salplan sp) {
		// TODO Auto-generated method stub
		saldao.updateSalplan(sp);
	}
	public PageUtil<Salchance> findSalPageByCon(int curpage, int row,
			Salchance sc) {
		// TODO Auto-generated method stub
		return saldao.querySalPageByCon(curpage, row, sc);
	}
	public PageUtil<Salchance> findSalPageByConn(int curpage, int row,
			Salchance sc) {
		// TODO Auto-generated method stub
		return saldao.querySalPageByConn(curpage, row, sc);
	}
	public void saveCustomerService(Cst_customer cc) {
		// TODO Auto-generated method stub
		saldao.saveCustomer(cc);
	}

	public int findUsr_idByName(String name) {
		// TODO Auto-generated method stub
		return saldao.getUsr_idByName(name);
	}

}
