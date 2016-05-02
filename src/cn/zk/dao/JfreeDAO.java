package cn.zk.dao;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

public interface JfreeDAO {
public  CategoryDataset Cstcontribute(String cust_name,String year) throws Exception;
public CategoryDataset CstMakeup(int condit) throws Exception;
public CategoryDataset CstService(String year) throws Exception;
}
