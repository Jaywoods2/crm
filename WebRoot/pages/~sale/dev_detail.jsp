<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jb-aptech毕业设计项目</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<!-- <div class="page_title">客户开发计划 &gt; 查看</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="back();">返回</button>
	</div>
-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">客户开发计划</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;查看</strong></td>
    </tr>
	<tr>
		<th>编号</th>
		<td><s:property value="sc.chc_id"/></td>
		<th>机会来源</th>
		<td><s:property value="sc.chc_source"/></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><s:property value="sc.chc_cust_name"/></td>
		<th>成功机率（%）</th>
		<td>&nbsp;<s:property value="sc.chc_rate"/></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td><s:property value="sc.chc_title"/></td>
		<th>状态</th>
		<td style="color:red;">开发成功</td>	
	</tr>
	<tr>
		<th>联系人</th>
		<td><s:property value="sc.chc_linkman"/></td>
		<th>联系人电话</th>
		<td><s:property value="sc.chc_tel"/></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><s:property value="sc.chc_desc"/></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><s:property value="sc.chc_create_by"/></td>
		<th>创建时间</th>
		<td><s:property value="sc.chc_create_date"/></td>
	</tr>
	<tr>
		<th>指派给</th>
		<td><s:property value="sc.chc_due_to"/></td>
		<th>指派时间</th>
		<td><s:property value="sc.chc_due_date"/></td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">返回</button> 
        </td>
    </tr>
</table>
<br />

<table class="data_list_table" id="table1" cellSpacing=1 cellPadding=1>
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	<s:iterator value="ssp">
	<tr>
		<td class="list_data_text"><s:property value="pla_date"/></td>
		<td class="list_data_text"><s:property value="pla_todo"/></td>
		<td class="list_data_text"><s:property value="pla_result"/></td>
			
	</tr>
	</s:iterator>
		</table>
</body>
</html>