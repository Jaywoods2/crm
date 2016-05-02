package cn.zk.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.zk.basd.Dict;
import cn.zk.service.DictService;
import cn.zk.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DictAction extends ActionSupport {
    private List<Dict> tt;
    private int curpage=1;
	private DictService dictService;
	private Dict p;
	private int dict_id;
	private int pgs;
	
	

	public int getPgs() {
		return pgs;
	}

	public void setPgs(int pgs) {
		this.pgs = pgs;
	}

	public int getDict_id() {
		return dict_id;
	}

	public void setDict_id(int dict_id) {
		this.dict_id = dict_id;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public List<Dict> getTt() {
		return tt;
	}

	public void setTt(List<Dict> tt) {
		this.tt = tt;
	}

	public Dict getP() {
		return p;
	}

	public void setP(Dict p) {
		this.p = p;
	}

	public DictService getDictService() {
		return dictService;
	}

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}

	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		if(!"ÊÇ".equals(p.getDict_is_editable())){
			p.setDict_is_editable("·ñ");
		}		
		dictService.savePersonService(p);
		
		return SUCCESS;
	}
	public String findall() throws Exception {
		// TODO Auto-generated method stub
		PageUtil<Dict>  pages=dictService.findPersonByPageService(curpage, 2);
		pgs=pages.getPages();
		tt=pages.getData();

		return "findchance";
	}
	public String update() throws Exception{
		dictService.updatePersonService(p);
		return "update";
	}
	public String findOneSalchance() throws Exception{
		p=dictService.findOneSalchance(dict_id);
		return "findsalchance";
	}
	public String deletePerson() throws Exception{
		
		dictService.deletePerson(dict_id);
		
		return "delcst";
	}
}
