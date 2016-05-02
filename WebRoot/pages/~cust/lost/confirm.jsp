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
    
    <title>My JSP 'confirm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
<script type="text/javascript">
	function lostsubmit(){
		$("#lostform").submit();
	}
</script>
  </head>
  
  <body>
   <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <tr>
   <TD class="page_title">客户流失管理&gt;确认流失</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
   </tr>
</table>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="lostsubmit()">保存</button>
</div>
<form action="${pageContext.request.contextPath }/pages/~cust/lost/lostupdate.action" method="post" id="lostform">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>编号</th>
		<td><s:property value="lost.lost_id"/>
		<input type="hidden" name="lost.lost_id" value="<s:property value="lost.lost_id"/>" />
		</td>
		<th>客户</th>
		<td><s:property value="lost.lost_cust_name"/></td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td><s:property value="lost.lost_mgr"/></td>
		<th>上次下单时间</th>
		<td><s:property value="lost.lost_last_odrdate"/>
			</td>
	</tr>
	<tr>
		<th>暂缓措施</th>
		<td colspan="3"><s:property value="lost.lost_step"/></td>
	</tr>	
	<tr>
		<th>流失原因</th>
		<td colspan="3">
			<textarea rows="6" cols="50" name="lost.lost_why"></textarea><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<br />
  </body>
</html>
