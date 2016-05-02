<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/script/common.js"></script>
  </head>
  
  <body>
   <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><s:property value="cs.cust_no" /></td>
		<th>客户名称</th>
		<td><s:property value="cs.cust_name" /></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="orders" var="odr">
	<tr>
		<td class="list_data_text"><s:property value="odr_id"/></td>
		<td class="list_data_text"><s:property value="odr_date"/></td>
		<td class="list_data_text"><s:property value="odr_addr"/></td>
		<td class="list_data_text">
		<s:if test="odr_status=='1'">已回款</s:if>
		<s:else>未回款</s:else>
		</td>
		<td class="list_data_op">
			<img onclick="to('${pageContext.request.contextPath}/pages/~cust/cust/orderdetails.action?odr_id=<s:property value="odr_id"/>');" title="查看明细" src="${pageContext.request.contextPath}/images/bt_detail.gif" class="op_button" /></td>
	</tr>
	</s:iterator>
	
	</table>
  </body>
</html>
