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

<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">客户开发计划</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<form action="${pageContext.request.contextPath}/salchance/salchance_planresult.action?chc_id=<s:property value="chc_id"/>" method="post">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;执行计划</strong></td>
    </tr>
    
	<tr>
		<th>编号</th>
		<td><input type="hidden" name="cc.Cust_no" value="<s:property value="sc.chc_id"/>"><s:property value="sc.chc_id"/></td>
		<th>机会来源</th>
		<td><s:property value="sc.chc_source"/></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><input type="hidden" name="cc.Cust_name" value="<s:property value="sc.chc_cust_name"/>"><s:property value="sc.chc_cust_name"/></td>
		<th>成功机率（%）</th>
		<td>&nbsp;<s:property value="sc.chc_rate"/></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><s:property value="sc.chc_title"/></td>
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
		<td><input type="hidden" name="cc.Cust_manager_name" value="<s:property value="sc.chc_due_to"/>"><s:property value="sc.chc_due_to"/></td>
		<th>指派时间</th>
		<td><s:property value="sc.chc_due_date"/></td>
	</tr>
	
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">终止开发</button>&nbsp;&nbsp;&nbsp;
			
			<a href="${pageContext.request.contextPath}/salchance/salchance_doplan.action?chc_id=<s:property value="chc_id"/>"><input class="common_button" size="60" type="button" value="制定计划"></a>&nbsp;&nbsp;&nbsp;
			
			<input class="common_button" size="60" type="submit" value="开发成功">&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="reload();">返回</button>
        </td>
    </tr>
</table>
</form>
<br />

<table class="data_list_table" id="table1" cellSpacing=1 cellPadding=1>
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	<s:iterator value="ssp">
	<tr>
	<form action="${pageContext.request.contextPath }/salchance/salplan_updatePlanResult.action?pla_id=<s:property value="pla_id"/>" method="post">
		<td class="list_data_text"><input name="sp.pla_date" readonly="readonly" value="<s:property value="pla_date"/>">
		<input name="sp.pla_id" type="hidden" value="<s:property value="pla_id"/> "/>
		<input name="sp.pla_chc_id" type="hidden" value="<s:property value="sc.chc_id"/> "/>
		
		</td>
		<td class="list_data_ltext"><input name="sp.pla_todo" readonly="readonly" value="<s:property value="pla_todo"/>" /></td>
		<td class="list_data_ltext"><input name="sp.pla_result" size="50" type="text" value="<s:property value="pla_result"/>"/>　
	
		<input class="common_button" type="submit" value="保存">
		</td>
		</form>
	</tr>
	</s:iterator>
	</table>
	
</body>
</html>