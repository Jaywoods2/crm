package cn.zk.util;

import java.util.List;
 
/**
 * 表示分页封装数据的工具类
 * @author Administrator
 *
 * @param <T>
 */
public class PageUtil<T> {
	
	private int curPage;
	
	private int pages;
	
	private int rows;
	
	public int ROW;
	
	private List<T> data;

	/**
	 * 得到当前页
	 * @return
	 */
	
	public int getCurPage() {
		return curPage;
	}
	public int getRows() {
		return rows;
	}
	public int getROW() {
		return ROW;
	}
	public void setROW(int rOW) {
		ROW = rOW;
	}
	/**
	 * 设置当前页
	 * @param curPage
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * 得到总页数
	 * @return
	 */
	public int getPages() {
		return pages;
	}

	

	/**
	 * 得到总页数
	 * @return
	 */
	public void setRows(int rows) {
		this.rows = rows;
		if(this.rows%ROW==0){
			this.pages=this.rows/ROW;
		}else{
			this.pages=this.rows/ROW+1;
		}
	}

	/**
	 * 得到数据
	 */
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
}
