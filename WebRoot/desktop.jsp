<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'desktop.jsp' starting page</title>
    
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
	<LINK 
	href="css/desktopPage.css" type=text/css rel=stylesheet>

  </head>
  
  <body>
 <DIV style="PADDING-RIGHT: 5px; PADDING-LEFT: 5px">
<DIV class=mtitle2><IMG height=15 src="images/ico_work.png" width=16 
align=absMiddle border=0>&nbsp;工作台 </DIV></DIV>
<TABLE cellSpacing=5 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD vAlign=top width="75%"><!-- news start -->
      <TABLE class=tabForm cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH>
            <DIV id=menuArrow1 
            style="BACKGROUND: no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle1 style="FONT-WEIGHT: bold">公司新闻</DIV></TH></TR>
        <TR>
          <TD width="100%">
            <DIV id=menu1>
            <TABLE width="100%" border=0>
              <TBODY>
              <TR>
                <TD vAlign=center align=middle width=80><IMG height=37 
                  src="images/gsxw.png" width=37></TD>
                <TD>
                  <TABLE cellPadding=5 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD>
                        <LI class=dot><A class=top 
                        href="#" 
                        target=_blank>通知开会JTY</A>[2008-10-23 
09:32:24]</LI></TD></TR>
                    <TR>
                      <TD align=right><A class=top 
                        href="#" 
                        target=_blank>&gt;&gt;更多新闻</A></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE><!-- news end --><BR><!-- customer visit start -->
      <TABLE class=tabForm cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH align=left>
            <DIV id=menuArrow5 
            style="BACKGROUND:no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle5 style="FONT-WEIGHT: bold">客户拜访</DIV></TH></TR>
        <TR>
          <TD width="100%">
            <DIV id=menu5>
            <TABLE width="100%" border=0>
              <TBODY>
              <TR>
                <TD vAlign=center align=middle width=80><IMG height=46 
                  src="images/khbf.png" width=46></TD>
                <TD>
                  <UL class=list>
                    <LI><A class=top 
                    href="">今天需要联系的客户:<SPAN 
                    class=red>0</SPAN>个</A> 
                    <LI><A class=top 
                    href="">已过期未联系的客户:<SPAN 
                    class=red>2</SPAN>个</A> 
                    <LI><A class=top 
                    href="">今天过生日的客户联系人:<SPAN 
                    class=red>0</SPAN>个</A> 
        </LI></UL></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE><!-- customer visit end --><BR 
      style="CLEAR: both"><!-- order_audit start -->
      <TABLE class=tabForm cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH align=left>
            <DIV id=menuArrow8 
            style="BACKGROUND:  no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle8 style="FONT-WEIGHT: bold">销售单审核</DIV></TH></TR>
        <TR>
          <TD width="100%">
            <DIV id=menu8>
            <TABLE width="100%" border=0>
              <TBODY>
              <TR>
                <TD vAlign=center align=middle width=80><IMG height=47 
                  src="images/xsd.png" width=39></TD>
                <TD>
                  <UL class=list>
                    <LI><A class=top 
                    href="-;flag=wait">待审核的销售单:<SPAN 
                    class=red>0</SPAN>个</A> 
                    <LI><A class=top 
                    href="#">审核已通过的销售单:<SPAN 
                    class=red>2</SPAN>个</A> 
                    <LI><A class=top 
                    href="#">审核未通过的销售单:<SPAN 
                    class=red>0</SPAN>个</A> 
        </LI></UL></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE><!-- order_audit end --><BR 
      style="CLEAR: both"><!-- complain start -->
      <TABLE class=tabForm cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH align=left>
            <DIV id=menuArrow9 
            style="BACKGROUND:   no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle9 style="FONT-WEIGHT: bold">收款单审核</DIV></TH></TR>
        <TR>
          <TD width="100%">
            <DIV id=menu9>
            <TABLE width="100%" border=0>
              <TBODY>
              <TR>
                <TD vAlign=center align=middle width=80><IMG height=51 
                  src="images/sksh.png" width=49></TD>
                <TD>
                  <UL class=list>
                    <LI><A class=top 
                    href="#">待审核的销售收款:<SPAN 
                    class=red>0</SPAN>个</A> 
                    <LI><A class=top 
                    href="#">审核已通过的销售收款:<SPAN 
                    class=red>0</SPAN>个</A> 
                    <LI><A class=top 
                    href="#">审核未通过的销售收款:<SPAN 
                    class=red>0</SPAN>个</A> 
        </LI></UL></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE><!-- complain end --><BR 
      style="CLEAR: both"></TD>
    <TD vAlign=top width="25%"><!-- affiche start -->
      <TABLE class=tabForm cellSpacing=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH align=left>
            <DIV id=menuArrow2 
            style="BACKGROUND: no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle2 style="FONT-WEIGHT: bold">公司公告</DIV></TH></TR>
        <TR>
          <TD>
            <DIV id=menu2>
            <TABLE cellSpacing=5 cellPadding=5 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width="70%"><br></TD>
                <TD width="30%"><br></TD></TR>
              </TBODY></TABLE></DIV><br></TD></TR></TBODY></TABLE><BR 
      style="CLEAR: both">
      <TABLE class=tabForm cellSpacing=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TH align=left>
            <DIV id=menuArrow12 
            style="BACKGROUND:   no-repeat center 50%; FLOAT: left"></DIV>
            <DIV id=menuTitle12 style="FONT-WEIGHT: bold">部门公告</DIV></TH></TR>
        <TR>
          <TD>
            <DIV id=menu12>
            <TABLE cellSpacing=5 cellPadding=5 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width="70%"></TD>
                <TD width="30%"></TD></TR>
              <TR>
                <TD colSpan=2>
                  <MARQUEE id=MARQUEE3 onmouseover=this.stop() 
                  onmouseout=this.start() scrollAmount=2 scrollDelay=0 
                  direction=up height=140 align="center" border="0"><A class=top 
                  href="#" 
                  target=_blank>
                  <DIV 
                  align=center>oooooooo<BR></DIV>sdfsdfsfsfdsfsfsfsdfsdfdsf</A><BR></MARQUEE>
                  <P align=right><A class=top 
                  href="#" 
                  target=_blank>&gt;&gt;更多公告</A></P></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE><!-- affiche end --></TD></TR></TBODY></TABLE>
  </body>
</html>
