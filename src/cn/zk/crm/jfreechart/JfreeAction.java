package cn.zk.crm.jfreechart;

import java.awt.Color;
import java.awt.Font;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;

import cn.zk.service.JfreeService;
import com.opensymphony.xwork2.ActionSupport;


public class JfreeAction extends ActionSupport {
	private JfreeService jfreeService;
	private JFreeChart chart;
	private int condit=0;
	private String cstname;
	private String year;
	

	public int getCondit() {
		return condit;
	}

	public void setCondit(int condit) {
		this.condit = condit;
	}

	public JfreeService getJfreeService() {
		return jfreeService;
	}

	public void setJfreeService(JfreeService jfreeService) {
		this.jfreeService = jfreeService;
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String getCstname() {
		return cstname;
	}

	public void setCstname(String cstname) {
		this.cstname = cstname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getcstcon() throws Exception{
	
		CategoryDataset dataset=jfreeService.findCstcontribute(cstname,year);
			chart=ChartFactory.createBarChart3D("客户贡献分析表", 
				"客户",
				"总金额",
				dataset,
				PlotOrientation.VERTICAL,//图表的方向
				true, //是否显示图例
				true, //是否显示工具提示
				true);//是否产生url链接
			
		//处理乱码
			//处理主题乱码
			chart.getTitle().setFont(new Font("黑体",Font.PLAIN,18));
			//处理子标题乱码
			chart.getLegend().setItemFont(new Font("黑体",Font.PLAIN,18));
				
		//获取图形的绘制机构
		CategoryPlot categoryPlot=(CategoryPlot) chart.getPlot();
		
		//设置网格背景颜色
		categoryPlot.setBackgroundPaint(Color.white);
		//设置网格竖线颜色
		categoryPlot.setDomainGridlinePaint(Color.pink);
		//设置网格横线颜色
		categoryPlot.setRangeGridlinePaint(Color.pink);
		//获取x轴
		CategoryAxis3D categoryAxis3D=(CategoryAxis3D) categoryPlot.getDomainAxis();
		//获取y轴
		NumberAxis3D numberAxis3D=(NumberAxis3D) categoryPlot.getRangeAxis();
		
		//处理x轴外乱码
		categoryAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,11));
		//处理x轴上乱码
		categoryAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,11));
		
		//处理y轴外、上乱码
		numberAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,12));
		numberAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,12));
		
		//设置y轴的刻度
		numberAxis3D.setAutoTickUnitSelection(true);		
		NumberTickUnit unit=new NumberTickUnit(40);
		numberAxis3D.setTickUnit(unit);
		
		BarRenderer3D barRenderer3D=(BarRenderer3D) categoryPlot.getRenderer();
		barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer3D.setBaseItemLabelsVisible(true);
		
		barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT)); 
		
		barRenderer3D.setBaseItemLabelFont(new Font("黑体",Font.PLAIN,15));
		barRenderer3D.setMaximumBarWidth(0.05);				
		return SUCCESS;
	}

	public String makeup() throws Exception{
		CategoryDataset dataset=jfreeService. findCstMakeup(condit);
		String title="";
		if(condit==0){
			title="客户级别百分比分析表";
		}else if(condit==1){
			title="客户信誉度分析表";
		}
		else if(condit==2){
			title="客户满意度分析表";
		}
		chart=ChartFactory.createBarChart3D(title, 
			"客户类型",
			"百分比",
			dataset,
			PlotOrientation.VERTICAL,//图表的方向
			true, //是否显示图例
			true, //是否显示工具提示
			false);//是否产生url链接
		
	//处理乱码
		//处理主题乱码
		chart.getTitle().setFont(new Font("黑体",Font.PLAIN,18));
		//处理子标题乱码
		chart.getLegend().setItemFont(new Font("黑体",Font.PLAIN,18));
			
	//获取图形的绘制机构
	CategoryPlot categoryPlot=(CategoryPlot) chart.getPlot();
	
	//设置网格背景颜色
	categoryPlot.setBackgroundPaint(Color.white);
	//设置网格竖线颜色
	categoryPlot.setDomainGridlinePaint(Color.pink);
	//设置网格横线颜色
	categoryPlot.setRangeGridlinePaint(Color.pink);
	//获取x轴
	CategoryAxis3D categoryAxis3D=(CategoryAxis3D) categoryPlot.getDomainAxis();
	//获取y轴
	NumberAxis3D numberAxis3D=(NumberAxis3D) categoryPlot.getRangeAxis();
	
	//处理x轴外乱码
	categoryAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,11));
	//处理x轴上乱码
	categoryAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,11));
	
	//处理y轴外、上乱码
	numberAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,12));
	numberAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,12));
	
	//设置y轴的刻度
	numberAxis3D.setAutoTickUnitSelection(true);		
	NumberTickUnit unit=new NumberTickUnit(0.25);
	numberAxis3D.setTickUnit(unit);
	
	BarRenderer3D barRenderer3D=(BarRenderer3D) categoryPlot.getRenderer();
	barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	barRenderer3D.setBaseItemLabelsVisible(true);
	
	barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT)); 
	
	barRenderer3D.setBaseItemLabelFont(new Font("黑体",Font.PLAIN,15));
	barRenderer3D.setMaximumBarWidth(0.05);	
		return SUCCESS;
	}
	
	public String getSev() throws Exception{
		
		if("".equals(year)){
			year=null;
		}
		CategoryDataset dataset=jfreeService.findCstService(year);
		chart=ChartFactory.createBarChart3D("客户服务分析", 
			"服务类型",
			"数量",
			dataset,
			PlotOrientation.VERTICAL,//图表的方向
			true, //是否显示图例
			true, //是否显示工具提示
			false);//是否产生url链接
		
	//处理乱码
		//处理主题乱码
		chart.getTitle().setFont(new Font("黑体",Font.PLAIN,18));
		//处理子标题乱码
		chart.getLegend().setItemFont(new Font("黑体",Font.PLAIN,18));
			
	//获取图形的绘制机构
	CategoryPlot categoryPlot=(CategoryPlot) chart.getPlot();
	
	//设置网格背景颜色
	categoryPlot.setBackgroundPaint(Color.white);
	//设置网格竖线颜色
	categoryPlot.setDomainGridlinePaint(Color.pink);
	//设置网格横线颜色
	categoryPlot.setRangeGridlinePaint(Color.pink);
	//获取x轴
	CategoryAxis3D categoryAxis3D=(CategoryAxis3D) categoryPlot.getDomainAxis();
	//获取y轴
	NumberAxis3D numberAxis3D=(NumberAxis3D) categoryPlot.getRangeAxis();
	
	//处理x轴外乱码
	categoryAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,11));
	//处理x轴上乱码
	categoryAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,11));
	
	//处理y轴外、上乱码
	numberAxis3D.setLabelFont(new Font("黑体",Font.PLAIN,12));
	numberAxis3D.setTickLabelFont(new Font("黑体",Font.PLAIN,12));
	
	//设置y轴的刻度
	numberAxis3D.setAutoTickUnitSelection(true);		
	NumberTickUnit unit=new NumberTickUnit(1);
	numberAxis3D.setTickUnit(unit);
	
	BarRenderer3D barRenderer3D=(BarRenderer3D) categoryPlot.getRenderer();
	barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	barRenderer3D.setBaseItemLabelsVisible(true);
	
	barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT)); 
	
	barRenderer3D.setBaseItemLabelFont(new Font("黑体",Font.PLAIN,15));
	barRenderer3D.setMaximumBarWidth(0.05);	
		
		return SUCCESS;
	}
}
