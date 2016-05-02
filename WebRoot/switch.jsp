<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'switch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK 
href="css/switchPage.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript>
<!--
function changeImg(){
	var S=document.getElementById("switchImg");
	var ss = S.src;
	if(ss.indexOf("cdsstsjal.png")!=-1) {
		ss = ss.replace("cdsstsjal.png","cdsstzkal.png");
		S.src = ss;
	}else{
		ss = ss.replace("cdsstzkal.png","cdsstsjal.png");
		S.src = ss;
	}
}
//-->
</SCRIPT>

  </head>
  
  <body>
   <TABLE height="100%" cellSpacing=0 cellPadding=0 width=8 border=0>
  <TBODY>
  <TR>
    <TD vAlign=center width=8 height="100%"><IMG id=switchImg 
      src="images/cdsstsjal.png"></TD></TR>
  <TR>
    <TD></TD></TR></TBODY></TABLE>
  </body>
</html>
