<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s"  uri="/struts-tags" %>
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

<!--<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="back();">返回</button>
	<button class="common_button" onClick="save('list.jsp');">保存</button>  
</div>-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">销售机会管理</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<form action="${pageContext.request.contextPath}/salchance/salchance_dispatch.action?chc_id=<s:property value="chc_id"/>" method="post">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;指派销售机会</strong></td>
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
		<td colspan="3"><s:property value="sc.chc_tel"/></td>
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
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">返回</button> 
&nbsp;&nbsp;
			<input type="submit" value="保存">
			 </td>
    </tr>
</table>
<br />

<table class="query_form_table" id="table1" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;指派</strong></td>
    </tr>
	<tr>
		<th>指派给</th>
		<td>
		<c:choose>
		  <c:when test="${sessionScope.user.usr_role_id<=2}">
			<select name="sc.chc_due_to"> 
			<s:iterator value="uls">
				<option><s:property value="usr_name" /></option>
				</s:iterator>
			</select> <span class="red_star">*</span>
		   </c:when>
		   <c:otherwise>
		   <select  disabled="disabled">
				<option>请选择...</option>
				</select>
		   </c:otherwise>
		   </c:choose>
		</td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="T20" value="当前系统时间" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<script>
	setCurTime('t2');
</script>
</body>
</html>