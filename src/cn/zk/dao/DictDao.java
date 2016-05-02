package cn.zk.dao;

import java.io.Serializable;
import java.util.List;

import cn.zk.basd.Dict;
import cn.zk.util.PageUtil;

public interface DictDao {

	public void savePerson(Dict p);
	public void deletePerson(Serializable dict_id);
	public void updatePerson(Dict p);
	public PageUtil<Dict> findPersonByPage(int curPage,int row);
	public Dict queryOneSalchance(Serializable dict_id);
}
