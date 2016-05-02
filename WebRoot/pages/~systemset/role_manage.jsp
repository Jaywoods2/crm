<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'role_manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/script/common.js"></script>

  </head>
  
  <body>
    <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <tr>
   <td class="page_title">系统设置</td>
   <td class="page_title_middle">&nbsp;</td>
   <td width=3><img height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
	</tr>
</table>
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;角色管理</strong></td>
    </tr>
	<tr>
		
</table>
<br />
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">编号</th>
		<th>角色名</th>
		<th>描述</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="roles">
	<tr>
		<td class="list_data_number"><s:property value="role_id" /></td>
		<td class="list_data_ltext"><s:property value="role_name" /></td>
		<td class="list_data_ltext"><s:property value="role_desc" /></td>
		<td class="list_data_text">
		<s:if test="role_flag==1">
			有效
		</s:if>
		<s:else>
			无效
		</s:else>
		</td>
		
		<td class="list_data_op">
		<c:choose>
			<c:when test="${sessionScope.user.usr_role_id==1}">
			<img onClick="to('${pageContext.request.contextPath }/pages/~systemset/roleedit.action?role_id=<s:property value="role_id" />');" title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" />
			</c:when>
			<c:otherwise>
			<img title="无编辑权限" src="${pageContext.request.contextPath}/images/bt_edit.png" class="op_button" />
			</c:otherwise>
		</c:choose>
			
		</td>
	</tr>
	</s:iterator>

</table>
  </body>
  <script src="${pageContext.request.contextPath}/js/changetrcolor.js" type="text/javascript"></script>
</html>
