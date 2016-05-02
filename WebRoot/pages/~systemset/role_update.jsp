<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'role_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/common.js"></script>

  </head>
  
  <body>
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
<tr>
   <td class="page_title">系统设置</td>
   <td class="page_title_middle">&nbsp;</td>
   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
	</tr>
</table>
<form action="${pageContext.request.contextPath}/pages/~systemset/roleupdate.action" method="post">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;修改角色</strong></td>
    </tr>
	<tr>
		<th>编号</th>
		<td><input readonly="readonly" name="role.role_id" type="text" value="<s:property value="role.role_id"/>"/></td>
	</tr>
	<tr>
		<th>角色名</th>
		<td><input type="text" name="role.role_name" value="<s:property value="role.role_name"/>" /><span class="red_star">*</span></td>
		
	</tr>
	<tr>
		<th>描述</th>
		<td><textarea cols="50" rows="4" name="role.role_desc"><s:property value="role.role_desc"/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>状态</th>
		<td colspan="3"><input name="role.role_flag" type="radio" value="1" checked="checked" />有效
			<input name="role.role_flag" type="radio" value="0" />无效</td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">返回</button> 
&nbsp;&nbsp;
	<input class="common_button" type="submit" value="保存 "/>
        </td>
    </tr>

</table>
</form>
  </body>
</html>
