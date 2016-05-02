package cn.zk.service;

import java.io.Serializable;
import java.util.List;

import cn.zk.basd.Dict;
import cn.zk.util.PageUtil;


public interface DictService {
	public void savePersonService(Dict p);
	public void deletePerson(Serializable dict_id);
	public void updatePersonService(Dict p);
	
	//分页 curPage 表示当前页   row 表示 每页多少行
	public PageUtil<Dict> findPersonByPageService(int curPage,int row);
	public Dict findOneSalchance(Serializable dict_id);
	
}
