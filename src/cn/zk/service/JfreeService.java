package cn.zk.service;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

public interface JfreeService {
	public CategoryDataset findCstcontribute(String cust_name,String year) throws Exception ;
	public CategoryDataset findCstMakeup(int condit) throws Exception;
	public CategoryDataset findCstService(String year) throws Exception;
}
