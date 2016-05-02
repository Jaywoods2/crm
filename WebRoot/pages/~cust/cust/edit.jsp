<%@ page language="java" import="java.util.*" 
pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/edit.js"></script>
  </head>
  
  <body>
<div class="page_title">客户信息管理 &gt; 客户信息</div>
<!--  -->
<form action="${pageContext.request.contextPath }/pages/~cust/cust/editchange.action" method="post" onsubmit="return editcheck()">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<input class="common_button" type="submit" value="保存" id="editcustbtn"/>
</div>
<input type="hidden" name="cs.cust_id" value="<s:property value="cs.cust_id"/>"/>
<input type="hidden" name="cs.cust_status" value="<s:property value="cs.cust_status"/>"/>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><s:property value="cs.cust_no"/><input type="hidden" name="cs.cust_no" value="<s:property value="cs.cust_no"/>"/></td>
		<th>名称</th>
		<td><input name="cs.cust_name" value="<s:property value="cs.cust_name"/>" id="cust_name"/><span class="red_star" id="cust_namespan">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<select name="cs.cust_region">
				<option value="0">请选择...</option>
				<option selected="selected" value="北京">北京</option>
				<option value="华北">华北</option>
				<option value="中南">中南</option>
				<option value="东北">东北</option>
				<option value="西部">西部</option>
			</select>
			<span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
			<c:choose>
				<c:when test="${sessionScope.user.usr_role_id<=2}">
					<select name="cs.cust_manager_name">
						<s:iterator value="uls">
						<option selected="selected" value="<s:property value="usr_id"/>,<s:property value="usr_name"/>"><s:property value="usr_name"/></option>

						</s:iterator>
					</select>
				</c:when>
			<c:otherwise>
				<select name="cs.cust_manager_name">
					<option selected="selected" value="<s:property value="cs.cust_manager_id"/>,<s:property value="cs.cust_manager_name"/>"><s:property value="cs.cust_manager_name"/></option>		
				</select>
			</c:otherwise>
			</c:choose>
					
			
			
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<select name="cs.cust_level_label">
				<option value="0">请选择...</option>
				<option selected="selected" value="1,普通客户">普通客户</option>
				<option value="2,重点开发客户">重点开发客户</option>
				<option value="3,大客户">大客户</option>
				<option value="4,合作伙伴">合作伙伴</option>
				<option value="5,战略合作伙伴">战略合作伙伴</option>
			</select><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="cs.cust_satisfy">
					<option value="0">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="cs.cust_credit">
					<option value="0">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><input  name="cs.cust_addr" id="cust_addr"/><span id="cust_addrspan">*</span>
		</td>
		<th>邮政编码</th>
		<td><input  name="cs.cust_zip" size="20" id="cust_zip"/><span class="red_star" id="cust_zipspan">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input name="cs.cust_tel" size="20"  id="cust_tel"/><span class="red_star" id="cust_telspan">*</span></td>
		<th>传真</th>
		<td>
			<input name="cs.cust_fax" size="20"  id="cust_fax"/><span class="red_star" id="cust_faxspan">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input  name="cs.cust_website" size="20"  id="cust_website"/><span class="red_star" id="cust_websitespan">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><input  name="cs.cust_licence_no" size="20" /></td>
		<th>法人</th>
		<td><input  name="cs.cust_chieftain" size="20" id="cust_chieftain"/><span class="red_star" id="cust_chieftainspan">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input  name="cs.cust_bankroll" size="20" /> </td>
		<th>年营业额</th>
		<td>
			<input name="cs.cust_turnover" size="20" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input  name="cs.cust_bank" size="20" id="cust_bank"/><span class="red_star" id="cust_bankspan">*</span>
		</td>
		<th>银行帐号</th>
		<td><input  name="cs.cust_bank_account" size="20" id="cust_bank_account"/><span class="red_star" id="cust_bank_accountspan">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input  name="cs.cust_local_tax_no" size="20" /></td>
		<th>国税登记号</th>
		<td><input  name="cs.cust_national_tax_no" size="20" /></td>
	</tr>
</table>
</form>

  </body>
</html>
