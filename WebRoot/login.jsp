<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
  	<script type="text/javascript">
  		function userlogin(){
  			$("#loginform").submit();
  		}
  	</script>
<style>
	th{
		font-size:12px;
		text-align:right;
		font-weight:normal;
	}
	td{
		font-size:12px;
		text-align:left;
	}
	input{
		width:100px;
		font-size:12px;
		border:solid 1px lightblue;
	}
</style>
  </head>
  
  <body BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 style="text-align:center;padding-top:20px;">
<center>
<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
  <tr>
		<td COLSPAN=7>
			<img src="${pageContext.request.contextPath}/images/login/login_01.gif" width=800 height=71 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=71 alt=""></td>
	</tr>
	<tr>
		<td COLSPAN=7>&nbsp;
		
		</td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=66 alt=""></td>
	</tr>
	<tr>
		<td COLSPAN=7>
			<img src="${pageContext.request.contextPath}/images/login/login_03.jpg" width=800 height=6 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=6 alt=""></td>
	</tr>
	<tr>
		
    <td COLSPAN=3>&nbsp; </td>
		<td COLSPAN=3 ROWSPAN=2>
			<img src="${pageContext.request.contextPath}/images/login/login_05.jpg" width=426 height=83 alt=""></td>
		
    <td ROWSPAN=3>&nbsp;</td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=44 alt=""></td>
	</tr>
	<tr>
		
    <td ROWSPAN=4>&nbsp; </td>
		<td COLSPAN=2>
			<img src="${pageContext.request.contextPath}/images/login/login_08.jpg" width=94 height=39 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=39 alt=""></td>
	</tr>
	<tr>
		<td ROWSPAN=3>
			<img src="${pageContext.request.contextPath}/images/login/login_09.jpg" width=15 height=141 alt=""></td>
		
    <td COLSPAN=2 ROWSPAN=2 background="${pageContext.request.contextPath}/images/login/login_10.jpg" >
<form action="${pageContext.request.contextPath}/userlogin.action" method="post" id="loginform">
<table width="100%">
        <tr> 
          <th>用户名</th>
          <td><input size="10" name="username" value="<s:property value="username"/>" maxlength="20" /></td>
        </tr>
        <tr> 
          <th>密码</th>
          <td><input type="password" name="password" size="10" maxlength="20" /></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><img onclick="userlogin()" src="${pageContext.request.contextPath}/images/login/login_button.jpg" width="73" height="25"></td>
        </tr>
        <tr>
         <td>&nbsp;</td>
       	 <td><font color="red" size="2"><s:fielderror fieldName="error"></s:fielderror></font></td>
        </tr>
      </table>
</form>
	
    </td>
		<td COLSPAN=2>
			<img src="${pageContext.request.contextPath}/images/login/login_11.jpg" width=304 height=86 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=86 alt=""></td>
	</tr>
	<tr>
		<td ROWSPAN=2>
			<img src="${pageContext.request.contextPath}/images/login/login_12.jpg" width=19 height=55 alt=""></td>
		
    <td COLSPAN=2 ROWSPAN=3>&nbsp; </td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=28 alt=""></td>
	</tr>
	<tr>
		<td COLSPAN=2>
			<img src="${pageContext.request.contextPath}/images/login/login_14.jpg" width=201 height=27 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=27 alt=""></td>
	</tr>
	<tr>
		
    <td COLSPAN=5>&nbsp; </td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=67 alt=""></td>
	</tr>
	<tr>
		
    <td COLSPAN=7 background="${pageContext.request.contextPath}/images/login/login_16.jpg" style="text-align:right;padding-right:25px;"> 
			&copy; 2008 长沙卓京信息技术有限公司
    </td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=1 height=55 alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=150 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=15 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=79 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=122 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=19 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=285 height=1 alt=""></td>
		<td>
			<img src="${pageContext.request.contextPath}/images/login/spacer.gif" width=130 height=1 alt=""></td>
		<td></td>
	</tr>
</TABLE>
</center>
  </body>
</html>
