<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据字典管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
</head>
<body>

<!--<div class="page_title">数据字典管理</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="to('${pageContext.request.contextPath}/pages/~basd/dict_add.jsp');">新建</button>
	<button class="common_button" onClick="reload();">查询</button>  
</div>-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">数据字典管理</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>类别</th>
		<td><input /></td>
		<th>条目</th>
		<td><input /></td>
		<th>值</th>
		<td><input /></td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="to('${pageContext.request.contextPath}/pages/~basd/dict_add.jsp');">新建</button>
&nbsp;&nbsp;
			<button class="common_button" onClick="reload();">查询</button> 
        </td>
    </tr>
</table>
<br />
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">检索结果</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">编号</th>
		<th>类别</th>
		<th>条目</th>
		<th>值</th>
		<th>是否可编辑</th>
		<th>操作</th>
	</tr>
	<s:iterator value="tt" var="ccc">
		<tr>
		<td class="list_data_number" ><s:property value="dict_id"/></td>
		<td class="list_data_text"><s:property value="dict_type"/></td>
		<td class="list_data_text"><s:property value="dict_item"/></td>
		<td class="list_data_text"><s:property value="dict_value"/></td>
		<td class="list_data_text">
		
		<s:property value="dict_is_editable"/>
		
		</td>
		
		
		<td class="list_data_op">
		<c:if test="${ccc.dict_is_editable=='是'}">
			<a href="${pageContext.request.contextPath }/pdict/dict_findOneSalchance.action?dict_id=<s:property value="dict_id"/>">
			<img  title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" /></a>
			<a href="javascript:if(confirm('确认删除？')){window.location.href='${pageContext.request.contextPath }/pdict/dict_deletePerson.action?dict_id=<s:property value="dict_id"/>'}" >
			<img  title="删除" src="${pageContext.request.contextPath}/images/bt_del.gif" class="op_button" /></a>
		</c:if>
		</td>
		</tr>
	</s:iterator>
	<tr>
		<th colspan="6" class="pager" align="right" style="padding-right:20px;">
<div class="pager">
	第<s:property value="curpage"/>页
	<a href="${pageContext.request.contextPath }/pdict/dict_findall.action?curpage=1">首页</a>
	<s:if test="curpage-1>0">
	<a href="${pageContext.request.contextPath }/pdict/dict_findall.action?curpage=${curpage-1}">上一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">上一页</font>
	</s:else>
	
	<s:if test="pgs-curpage>0">
	<a href="${pageContext.request.contextPath }/pdict/dict_findall.action?curpage=${curpage+1}">下一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">下一页</font>
	</s:else>
	<a href="${pageContext.request.contextPath }/pdict/dict_findall.action?curpage=${pgs}">尾页</a>
	<form action="${pageContext.request.contextPath }/pdict/dict_findall.action" method="post">
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