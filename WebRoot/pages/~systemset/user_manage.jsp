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
    
    <title>My JSP 'user_manage.jsp' starting page</title>
    
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
   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
   </tr>
</table>
<p style="font-size: 11px;">1:系统管理员　２:销售主管　3:客户经理　4:高管</p>
<table class="query_form_table" cellSpacing=1 cellPadding=1 style="text-align: center;">
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;用户管理</strong></td>
    </tr>
	<tr>
		<th id="firstth">编号</th>
		<th>用户名</th>
		<th>角色等级</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pages.data">
	<tr>
		<td class="list_data_number"><s:property value="usr_id"/></td>
		<td class="list_data_ltext"><s:property value="usr_name"/></td>
		<td class="list_data_ltext"><s:property value="usr_role_id"/></td>
		<td class="list_data_text">
		<s:if test="usr_flag==1">
			正常
		</s:if>
		<s:elseif test="usr_flag==-1">
		不正常
		</s:elseif>
		</td>
		<td class="list_data_op">
		<img onClick="to('user_update.html');" title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" /></td>
	</tr>
	</s:iterator>
	<tr>
	<td colspan="5">
	共<s:property value="pages.rows"/>条记录 每页 5 条
	第<s:property value="curpage"/>页
	<a href="${pageContext.request.contextPath }/pages/~systemset/user2all.action?curpage=1">首页</a>
	<s:if test="curpage-1>0">
	<a href="${pageContext.request.contextPath }/pages/~systemset/user2all.action?curpage=${curpage-1}">上一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">上一页</font>
	</s:else>
	
	<s:if test="pgs-curpage>0">
	<a href="${pageContext.request.contextPath }/pages/~systemset/user2all.action?curpage=${curpage+1}">下一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">下一页</font>
	</s:else>
	<a href="${pageContext.request.contextPath }/pages/~systemset/user2all.action?curpage=${pgs}">尾页</a>
	</td>
	</tr>
</table>
<br />
  </body>
</html>
