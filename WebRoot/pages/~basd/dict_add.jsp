<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据字典管理 > 新建数据字典条目</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
</head>
<body>
	
<!--<div class="page_title">数据字典管理 > 新建数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="back();">返回</button>
	<button class="common_button" onClick="add('dict.jsp');">保存</button>  
</div>
-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title"> 新建数据字典条目</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<form action="${pageContext.request.contextPath}/pdict/dict_add.action" method="post">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input readonly/></td>
		<th>类别</th>
		<td><input type="text" name="p.dict_type"/><span class="red_star"></span><br /></td>
	</tr>
	<tr>
		<th>条目</th>
		<td><input type="text" name="p.dict_item"/><span class="red_star"></span></td>
		<th>值</th>
		<td><input type="text" name="p.dict_value"/><span class="red_star"></span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<td><input type="checkbox" checked name="p.dict_is_editable" value="是"  /></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
    <tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help();">帮助</button>&nbsp;&nbsp;&nbsp;
			<input class="common_button" type="button" value="返回" onClick="history.go(-1)"/>
&nbsp;&nbsp;
			<input class="common_button" type="submit" value="保存"/> 
			
        </td>
    </tr>
</table>
</form>
</body>
</html>