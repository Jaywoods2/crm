<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户贡献</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
  	<script src="${pageContext.request.contextPath }/script/jquery-1.4.1.js"></script>
	<script type="text/javascript" charset="utf-8">	
		function chaxungongxian(){
			//alert($("#cstgongxianname").val());
			//alert("${pageContext.request.contextPath }/pages/~rept/jfreegetcstcon.action?cstname="+$("#cstgongxianname").val()+"&&year="+$("#cstodryear").val());
			$("#kehugongxian").attr("src","${pageContext.request.contextPath }/pages/~rept/jfreegetcstcon.action?cstname="+$("#cstgongxianname").val()+"&year="+$("#cstodryear").val());
		}
	</script>
  </head> 
  <body>
	<div class="page_title">客户贡献分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="chaxungongxian();">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="cstname" type="text" id="cstgongxianname"/></td>
		<th>年份</th>
		<td>
			<select name="year" id="cstodryear">
				<option value="">全部</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
			</select>
		</td>
	</tr>
	</table>
	<br />
	
	<div style="width:800px;margin:20px auto">
	 <img src="${pageContext.request.contextPath }/pages/~rept/jfreegetcstcon.action" width=800 height=400 border=0 id="kehugongxian">
	</div>


  </body>
</html>
