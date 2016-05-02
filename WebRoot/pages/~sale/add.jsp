<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script src="../script/common.js" >

</script>

</head>
<script type="text/javascript">
   function check(){
   var aaa=document.getElementById("txt").value ;

   if(aaa==""){
   alert("客户名不能为空");
   return false;
     }
     return true;
   }
  </script>
<body>

<!--<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="back();">返回</button>
	<button class="common_button" onClick="add('list.jsp');">保存</button>  
</div>-->
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
   <TD class="page_title">销售机会管理</TD>
   <TD class="page_title_middle">&nbsp;</TD>
   <TD width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></TD>
</table>

<form action="${pageContext.request.contextPath }/salchance/salchance_add.action" method="post" onsubmit="return check()">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
			<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;新建销售机会</strong></td>
    </tr>
	<tr>
		<th>编号</th>
		<td><input readonly value="系统自己添加"/></td>
		<th>机会来源</th>
		<td>
			<input type="text" name="sc.chc_source" size="20" /></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><input type="text" name="sc.chc_cust_name" id="txt" /><span class="red_star">*</span></td>
		<th>成功机率</th>
		<td><input type="text" name="sc.chc_rate"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><input type="text" name="sc.chc_title" size="52" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><input type="text" name="sc.chc_linkman" size="20" /></td>
		<th>联系人电话</th>
		<td><input type="text" name="sc.chc_tel" size="20" /></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><textarea rows="6" cols="50" name="sc.chc_desc"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input name="sc.chc_create_by" value="${sessionScope.user.usr_name }" readonly size="20" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="t1"  readonly size="20" value="系统当前时间"/><span class="red_star">*</span></td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="back();">返回</button> 
&nbsp;&nbsp;
			<input type="submit" value="保存" >  
        </td>
    </tr>
</table>
</form>
<br />
<!--
<table disabled class="query_form_table" id="table1" cellSpacing=1 cellPadding=1>
	<tr>
		<th>指派给</th>
		<td>
			<select name="D1">
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select> <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
-->
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>