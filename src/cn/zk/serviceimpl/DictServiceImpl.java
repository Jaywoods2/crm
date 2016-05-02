package cn.zk.serviceimpl;

import java.io.Serializable;
import java.util.List;

import cn.zk.basd.Dict;
import cn.zk.dao.DictDao;
import cn.zk.service.DictService;
import cn.zk.util.PageUtil;

public class DictServiceImpl implements DictService {

	private DictDao dictDao;

	public DictDao getDictDao() {
		return dictDao;
	}

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public void deletePerson(Serializable dict_id) {
		// TODO Auto-generated method stub
		dictDao.deletePerson(dict_id);

	}

	public PageUtil<Dict> findPersonByPageService(int curPage, int row) {
		// TODO Auto-generated method stub
		
		return dictDao.findPersonByPage(curPage, row);
	}

	public void savePersonService(Dict p) {
		// TODO Auto-generated method stub
		dictDao.savePerson(p);
	}

	public void updatePersonService(Dict p) {
		// TODO Auto-generated method stub
		dictDao.updatePerson(p);
	}

	public Dict findOneSalchance(Serializable dict_id) {
		// TODO Auto-generated method stub
		return dictDao.queryOneSalchance(dict_id);
	}

}
