<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>log_review</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/js/date.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common.js"></script>

  </head>
  
  <body>


	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
	   <td class="page_title">检索结果</td>
	   <td class="page_title_middle">&nbsp;</td>
	   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
	</tr>
	</table>
	<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1 style="text-align: center;">
	<tr>
    	
        <th id="firstth">时间</th>
        <th>操作员</th>
		<th colspan="3">事件</th>
	</tr>
	
    <s:iterator value="page.data" var="log">
    <tr>
    	<td><fmt:formatDate value="${log.log_date}" pattern="yyyy年MM月dd日:HH时mm分ss秒" dateStyle="long" type="date"/>
    	<td><s:property value="log_op" /></td>
		<td colspan="3"><s:property value="log_event"/></td>
	</tr>
    </s:iterator>
    <tr>
    
    <td colspan="3"><a href="${pageContext.request.contextPath }/pages/~systemset/logloglist.action?curpage=1">首页</a>　　
    <s:if test="curpage>1">
    <a href="${pageContext.request.contextPath }/pages/~systemset/logloglist.action?curpage=<s:property value="curpage-1"/>">上一页</a>　
    </s:if>
    <s:else>
    	上一页
    </s:else>　
    <s:if test="pgs-curpage>0">
     <a href="${pageContext.request.contextPath }/pages/~systemset/logloglist.action?curpage=<s:property value="curpage+1"/>">下一页</a>　　　
    	</s:if>
    <s:else>
    	下一页　　
    </s:else>
    	<a href="${pageContext.request.contextPath }/pages/~systemset/logloglist.action?curpage=<s:property value="pgs"/>">尾页</a>
    	</td>
    </tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">返回</button> 
&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/pages/~systemset/logwriteexcel.action"><button class="common_button">导出</button></a>
        </td>
    </tr>

</table>
  </body>
  <script src="${pageContext.request.contextPath}/js/changetrcolor.js" type="text/javascript"></script>
</html>
