package cn.zk.crm.system;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import cn.zk.entity.Cst_log;
import cn.zk.service.LogService;
import cn.zk.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport {
	private LogService logService;
	private int curpage;
	private PageUtil<Cst_log> page;
	private int pgs;
	

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public PageUtil<Cst_log> getPage() {
		return page;
	}

	public void setPage(PageUtil<Cst_log> page) {
		this.page = page;
	}

	public int getPgs() {
		return pgs;
	}

	public void setPgs(int pgs) {
		this.pgs = pgs;
	}
	


	public String loglist(){
		try {
			page=logService.findAllLogPage(curpage, 20);
			pgs=page.getPages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public InputStream getInput(){
		WritableWorkbook book = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		 try {
			book = Workbook.createWorkbook(os);
			WritableSheet sheet = book.createSheet("客户关系管理系统日志", 0);
			List<Cst_log> loglist=logService.findAllLog();
			if(loglist!=null&&!loglist.isEmpty()){
				for(int i=0;i<loglist.size();i++){
					 sheet.addCell(new Number(0, i, loglist.get(i).getLog_id()));
					 sheet.addCell(new Label(1, i, loglist.get(i).getLog_date().toString()));
					 sheet.addCell(new Label(2, i, loglist.get(i).getLog_op()));
					 sheet.addCell(new Label(4, i, loglist.get(i).getLog_event()));
					 
				}
			}
			// 写入数据并关闭文件
            book.write();
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(book!=null){
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
		}}		
		return new ByteArrayInputStream(os.toByteArray());
	}
	public String writeexcel(){
		return "excel";
	}
}
