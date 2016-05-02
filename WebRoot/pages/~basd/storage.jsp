<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>库存查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">

</head>
<body>

<!--<div class="page_title">库存查询</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="reload();">查询</button>  
</div>-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">库存查询</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>产品</th>
		<td><input /></td>
		<th>仓库</th>
		<td><input /></td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="reload();">查询</button> 
        </td>
    </tr>
</table>
<br />
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">检索结果</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">序号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_ltext">幸福牌电视机-818 FFT-2388 EA03</td>
		<td class="list_data_ltext">北京-西直门库</td>
		<td class="list_data_text">EC-D2</td>
		<td class="list_data_number">16</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
	<tr>
		<td class="list_data_number">2</td>
		<td class="list_data_ltext">海龙笔记本电脑-i60-2688 9966</td>
		<td class="list_data_ltext">北京-大钟寺库</td>
		<td class="list_data_text">EA-B8</td>
		<td class="list_data_number">12</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
	<tr>
		<td class="list_data_number">3</td>
		<td class="list_data_ltext">海龙笔记本电脑-i60-2688 9966</td>
		<td class="list_data_ltext">北京-马甸库</td>
		<td class="list_data_text">EA-A6</td>
		<td class="list_data_number">8</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
	<tr>
		<td class="list_data_number">4</td>
		<td class="list_data_ltext">海龙笔记本电脑-i61-2689 6688</td>
		<td class="list_data_ltext">天津-恒远电子C库</td>
		<td class="list_data_text">北26位</td>
		<td class="list_data_number">36</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
		<tr>
		<td class="list_data_number">5</td>
		<td class="list_data_ltext">海龙笔记本电脑-i61-2689 6688</td>
		<td class="list_data_ltext">天津-恒远电子C库</td>
		<td class="list_data_text">北27位</td>
		<td class="list_data_number">36</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
		<tr>
		<td class="list_data_number">6</td>
		<td class="list_data_ltext">海龙笔记本电脑-i61-2689 6688</td>
		<td class="list_data_ltext">天津-恒远电子C库</td>
		<td class="list_data_text">北28位</td>
		<td class="list_data_number">30</td>
		<td class="list_data_ltext">&nbsp;</td>		
	</tr>
	<tr>
		<th colspan="100" class="pager" align="right" style="padding-right:20px;">
<div class="pager">
	共59条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onClick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
<script src="${pageContext.request.contextPath}/js/changetrcolor.js" type="text/javascript"></script>
</html>