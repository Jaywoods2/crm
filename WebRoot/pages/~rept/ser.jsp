<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
  	<script type="text/javascript">
  		function chaxun22(){
  		var v=$("#sevyear").val();
  		$("#serimg").attr("src","${pageContext.request.contextPath }/pages/~rept/jfreegetSev.action?year="+v);
  		}
  	</script>
  </head>
  
  <body>
  <div class="page_title">客户服务分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="chaxun22()">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>年份</th>
		<td>
			<select id="sevyear">
				<option>全部</option>
				<option>2013</option>
				<option>2014</option>
				<option>2015</option>
				<option>2016</option>
			</select>
		</td>
		<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
	</tr>
	</table>
<br />
<center>
	<img alt="服务类型分析" src="${pageContext.request.contextPath }/pages/~rept/jfreegetSev.action" width=800 height=400 border=0 id="serimg"/>
</center>
  </body>
</html>
