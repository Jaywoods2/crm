<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>交往记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
  	<script type="text/javascript">
  		function delatv2(msg,atv_id){
  		if (window.confirm("确认删除"+msg+"吗？")){
  			$("#atvhid2").val(atv_id);
  			$("#delatvform2").submit();
  			}
  		}
  	</script>
  </head>
  
  <body>
   <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('${pageContext.request.contextPath}/pages/~cust/cust/activities_add.jsp?cust_id=<s:property value="cs.cust_id"/>');">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><s:property value="cs.cust_no"/></td>
		<th>客户名称</th>
		<td><s:property value="cs.cust_name"/></td>
	</tr>
	</table>
<br />

<table class="data_list_table">
	<tr>
		<th width="232">时间</th>
		<th>地点</th>
		<th>概要</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="atvs">
	<tr>
		<td class="list_data_text" width="230"><s:property value="atv_date"/></td>
		<td class="list_data_text"><s:property value="atv_place"/></td>
		<td class="list_data_ltext"><s:property value="atv_title"/></td>
		<td class="list_data_ltext"><s:property value="atv_desc"/></td>
		<td class="list_data_op">
			<img onclick="to('${pageContext.request.contextPath}/pages/~cust/cust/atvqueryone.action?atv_id=<s:property value="atv_id"/>');" title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" />
			<img onclick="delatv2('“交往记录：<s:property value="atv_title"/>”',<s:property value="atv_id"/>);" title="删除" src="${pageContext.request.contextPath}/images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	</table>
	<form action="${pageContext.request.contextPath}/pages/~cust/cust/atvdel.action" method="post" id="delatvform2">
	<input type="hidden" name="atv_id" value="" id="atvhid2">
	</form>
  </body>
</html>
