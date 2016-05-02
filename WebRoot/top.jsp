<%@ page language="java" import="java.util.*" 
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK 
href="css/style_cn.css" type=text/css rel=stylesheet><LINK 
href="css/calendar-win2k-cold-1.css" type=text/css rel=stylesheet>
<SCRIPT src="js/global.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/menu.js" type=text/javascript></SCRIPT>


<STYLE type=text/css>.unnamed1 {
	FONT-SIZE: 12px; LINE-HEIGHT: 20px
}
BODY {
	MARGIN: 0px
}
A {
	FONT-SIZE: 12px; FONT-FAMILY: 宋体,Arial,sans-serif; TEXT-DECORATION: none
}
A.top:link {
	COLOR: #ffffff; TEXT-DECORATION: none
}
A.top:visited {
	COLOR: #ffffff; TEXT-DECORATION: none
}
A.top:hover {
	COLOR: #ffffff; TEXT-DECORATION: none
}
A.top:active {
	COLOR: #ffffff; TEXT-DECORATION: none
}
</STYLE>
<script type="text/javascript">
	window.onload=function(){
//定时器每秒调用一次fnDate()
setInterval(function(){
fnDate();
},1000);
}
//js 获取当前时间
function fnDate(){
var oDiv=document.getElementById("div");
var date=new Date();
var year=date.getFullYear();//当前年份
var month=date.getMonth();//当前月份
var data=date.getDate();//天
var hours=date.getHours();//小时
var minute=date.getMinutes();//分
var second=date.getSeconds();//秒
var time=year+"-"+fnW((month+1))+"-"+fnW(data)+" "+fnW(hours)+":"+fnW(minute)+":"+fnW(second);
oDiv.innerHTML=time;
}
//补位 当某个字段不是两位数时补0
function fnW(str){
var num;
str>=10?num=str:num="0"+str;
return num;
} 
</script>
  </head>
  
  <body>
  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD width=200 height=65><IMG height=65 src="images/logo1.gif" width=200 
      border=0></TD>
    <TD background="images/topbg.gif" height=65>&nbsp;</TD>
    <TD width=158 height=65><IMG height=65 src="images/logo2.gif" width=158 
      border=0></TD></TR></TBODY></TABLE><!-- welcome end --><!-- user info start  -->
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD class=unnamed1 noWrap background="images/tsxxlbjzb.png "
      height=30>&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.user.usr_name } 欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;  
    </TD>
    <TD noWrap width=37><IMG height=30 src="images/tsxxlbjhx.png" 
    width=37></TD>
    <TD noWrap width=630 background="images/tsxxlbjyb.png" id="div"><FONT 
      color=#ffffff > 
       
      </FONT></TD></TR></TBODY></TABLE><!-- user info end -->
  </body>
</html>
