<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="${pageContext.request.contextPath}/script/common.js"></script>
</head>
<body>

<!--<div class="page_title">客户开发计划</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="reload();">查询</button> 
	</div>-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">客户开发计划</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<form action="${pageContext.request.contextPath }/salchance/salchance_findbycon2.action" method="post">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>客户名称</th>
		<td><input type="text" name="sc.chc_cust_name"/></td>
		<th>概要</th>
		<td><input type="text" name="sc.chc_title"/></td>
		<th>联系人</th>
		<td><input type="text" name="sc.chc_linkman" size="20" /></td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;
			<input class="common_button" type="submit" value="查询">
        </td>
    </tr>
</table>
</form>
<br />
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">检索结果</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	
	
	<s:iterator value="ssc" var="aaa">
	<c:choose>
	<c:when test="${aaa.chc_status=='开发中'}">
	<tr>
	
		<td class="list_data_number"><s:property value="chc_id"/></td>
		<td class="list_data_text"><s:property value="chc_cust_name"/></td>
		<td class="list_data_ltext"><s:property value="chc_desc"/></td>
		<td class="list_data_text"><s:property value="chc_linkman"/></td>
		<td class="list_data_text"><s:property value="chc_tel"/></td>
		<td class="list_data_text"><s:property value="chc_create_date"/></td>
		<td class="list_data_text"><s:property value="chc_status"/></td>
		<c:choose>
		    <c:when test="${sessionScope.user.usr_name==aaa.chc_due_to || sessionScope.user.usr_role_id<=2}">
		<td class="list_data_op">
			<a href="${pageContext.request.contextPath}/salchance/salchance_doplan.action?chc_id=<s:property value="chc_id"/>"><img title="制定计划" src="${pageContext.request.contextPath}/images/bt_plan.gif" class="op_button" /></a>
			<a href="${pageContext.request.contextPath}/salchance/salchance_todoplan.action?chc_id=<s:property value="chc_id"/>"><img title="执行计划" src="${pageContext.request.contextPath}/images/bt_feedback.gif" class="op_button" /></a>
			<img onClick="alert('用户开发成功，已添加新客户记录。');" title="开发成功" src="${pageContext.request.contextPath}/images/bt_yes.gif" class="op_button" />
		</td>
		</c:when>
		<c:otherwise>
		<td class="list_data_op">
			<img title="制定计划" src="${pageContext.request.contextPath}/images/bt_plan.png" class="op_button" />
			<img title="执行计划" src="${pageContext.request.contextPath}/images/bt_feedback.png" class="op_button" />
			<img  title="开发成功" src="${pageContext.request.contextPath}/images/bt_yes.gif" class="op_button" />
		</td>
		</c:otherwise>
		</c:choose>
	</tr>
	</c:when>
	<c:otherwise>
	  <tr>
	    <td class="list_data_number"><s:property value="chc_id"/></td>
		<td class="list_data_text"><s:property value="chc_cust_name"/></td>
		<td class="list_data_ltext"><s:property value="chc_desc"/></td>
		<td class="list_data_text"><s:property value="chc_linkman"/></td>
		<td class="list_data_text"><s:property value="chc_tel"/></td>
		<td class="list_data_text"><s:property value="chc_create_date"/></td>
		<td class="list_data_text"><s:property value="chc_status"/></td>
		
		<td class="list_data_op">
		<a href="${pageContext.request.contextPath}/salchance/salchance_findtoplan.action?chc_id=<s:property value="chc_id"/>"><img onClick="to('${pageContext.request.contextPath}/pages/~sale/dev_detail.jsp');" title="查看" src="${pageContext.request.contextPath}/images/bt_detail.gif" class="op_button" /></a>
		</td>
	  </tr>
	</c:otherwise>
	</c:choose>
	</s:iterator>
	
	
	
	
	<!--<tr>
		<td class="list_data_number">2</td>
		<td class="list_data_text">泰宝实业</td>
		<td class="list_data_ltext">采购笔记本电脑意向</td>
		<td class="list_data_text">马先生</td>
		<td class="list_data_text">13333239239</td>
		<td class="list_data_text">2007年11月16日</td>
		<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onClick="to('${pageContext.request.contextPath}/pages/~sale/dev_detail.jsp');" title="查看" src="${pageContext.request.contextPath}/images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	--><tr>
		<th colspan="10" class="pager">
<div class="pager">
	 每页 2 条
	第<s:property value="curpage"/>页
	<a href="${pageContext.request.contextPath }/salchance/salchance_findplan.action?curpage=1">首页</a>
	<s:if test="curpage-1>0">
	<a href="${pageContext.request.contextPath }/salchance/salchance_findplan.action?curpage=${curpage-1}">上一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">上一页</font>
	</s:else>
	
	<s:if test="pgs-curpage>0">
	<a href="${pageContext.request.contextPath }/salchance/salchance_findplan.action?curpage=${curpage+1}">下一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">下一页</font>
	</s:else>
	<a href="${pageContext.request.contextPath }/salchance/salchance_findplan.action?curpage=${pgs}">尾页</a>
	<form action="${pageContext.request.contextPath }/salchance/salchance_findall.action" method="post">
	转到<input value="<s:property value="curpage"/>" size="1" name="curpage" id="curpages"/>页
	<input  type="submit" value="GO"/>
</form>
</div>
		</th>
	</tr>
</table>
</body>
<script src="${pageContext.request.contextPath}/js/changetrcolor.js" type="text/javascript"></script>
</html>