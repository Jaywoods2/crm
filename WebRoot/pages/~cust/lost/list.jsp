<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/script/common.js"></script>

  </head>
  
  <body>
   <br /><br />
<br />
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
<tr>
   <td class="page_title">客户流失管理</td>
   <td class="page_title_middle">&nbsp;</td>
   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
</tr>
</table>
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">编号</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>上次下单时间</th>
		<th>确认流失时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="losts" var="lo">
	<tr>
		<td class="list_data_number"><s:property value="lost_id" /></td>
		<td class="list_data_text"><s:property value="lost_cust_name" /></td>
		<td class="list_data_ltext"><s:property value="lost_mgr" /></td>
		<td class="list_data_text"><s:property value="lost_last_odrdate" /></td>
		<td class="list_data_text"><s:property value="lost_okdate"/></td>
		<td class="list_data_text">
			<s:if test="lost_statue==0">
			暂缓流失
			</s:if>
			<s:else>
			已流失
			</s:else>
			
		</td>
		<td class="list_data_op">
		<s:if test="lost_statue==0">
			<img onClick="to('${pageContext.request.contextPath}/pages/~cust/lost/lostcomfirm.action?lost_id=<s:property value="lost_id" />');" title="确认流失" src="${pageContext.request.contextPath}/images/bt_confirm.gif" class="op_button" />
			</s:if>
			
			
		</td>
	</tr>
	</s:iterator>
</table>
  </body>
</html>
