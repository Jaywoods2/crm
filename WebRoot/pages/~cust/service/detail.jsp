<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.zk.entity.Cst_service"%>
<%@page import="cn.zk.service.Cst_serviceService"%>
<%@page import="cn.zk.serviceimpl.Cst_serviceServiceImpl"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${pageContext.request.contextPath}/css/test1.css"
			rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/script/common.js"></script>
	</head>
	<body>

		<!--<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="back();">返回</button>  
</div>-->
		<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
			<TD class="page_title">
				客户服务管理
			</TD>
			<TD class="page_title_middle">
				&nbsp;
			</TD>
			<TD width=3>
				<IMG height=32
					src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3>
			</TD>
		</table>
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<td width=100% height=30 align=left
					background="${pageContext.request.contextPath}/images/m_table_top.jpg"
					colspan="6">
					<strong>&nbsp;服务归档</strong>
				</td>
			</tr>
			<tr>
				<th>
					编号
				</th>
				<td>
					<input type="text" name="cs.svr_id" id="cs.svr_id"
						value="${cst.svr_id }" />
				</td>
				<th>
					服务类型
				</th>
				<td>
					<input type="text" name="cs.svr_type" id="cs.svr_type"
						value="${cst.svr_type }" />
				</td>
			</tr>
			<tr>
				<th>
					概要
				</th>
				<td colspan="3">
					<input type="text" name="cst.svr_title" id="cst.svr_title"
						value="${cst.svr_title }" />
				</td>
			</tr>
			<tr>
				<th>
					客户
				</th>
				<td>
					<input type="text" name="cst.svr_cust_name" id="cst.svr_cust_name"
						value="${cst.svr_cust_name }" />
				</td>
				<th>
					状态
				</th>
				<td>
					<input type="text" name="cst.svr_status" id="cst.svr_status"
						value="已归档">
				</td>
			</tr>
			<tr>
				<th>
					服务请求
				</th>
				<td colspan="3">
					<input type="text" name="cst.svr_request" id="cst.svr_request"
						value="${cst.svr_request }" />
					<br>
				</td>
			</tr>
			<tr>
				<th>
					创建人
				</th>
				<td>
					<input type="text" name="cst.svr_create_by" id="cst.svr_create_by"
						value="${cst.svr_create_by }" />
				</td>
				<th>
					创建时间
				</th>
				<td>
					<input type="text" name="cst.svr_create_date"
						id="cst.svr_create_date" value="${cst.svr_create_date }" />
				</td>
			</tr>
		</table>
		<br />
		<table class="query_form_table" id="table3" cellSpacing=1
			cellPadding=1>
			<tr>
				<th>
					分配给
				</th>
				<td>
					<input type="text" name="cst.svr_due_to" id="cst.svr_due_to"
						value="${ cst.svr_due_to}" />
				</td>
				<th>
					分配时间
				</th>
				<td>
					<input type="text" name="cst.svr_due_date" id="cst.svr_due_date"
						value="${cst.svr_due_date }" />
				</td>
			</tr>
		</table>
		<br />
		<table class="query_form_table" id="table1" cellSpacing=1
			cellPadding=1>
			<tr>
				<th>
					服务处理
				</th>
				<td colspan="4">
					<input type="text" name="cst.svr_deal" id="cst.svr_deal"
						value="${cst.svr_deal }" />
				</td>
			</tr>
			<tr>
				<th>
					处理人
				</th>
				<td>
					郭小美
				</td>
				<th>
					处理时间
				</th>
				<td>
					<input type="text" name="cst.svr_deal_date" id="cst.svr_deal_date"
						value="${cst.svr_deal_date }" />
				</td>
			</tr>
		</table>
		<br />
		<table class="query_form_table" id="table2" cellSpacing=1
			cellPadding=1>
			<tr>
				<th>
					处理结果
				</th>
				<td>
					<input type="text" name="cst.svr_result" id="cst.svr_result"
						value="${cst.svr_result }" />
				</td>
				<th>
					满意度
				</th>
				<td>
				<c:if test="${cst.svr_satisfy=='5'}">
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
				</c:if>
				<c:if test="${cst.svr_satisfy=='4'}">
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
				</c:if>
				<c:if test="${cst.svr_satisfy=='3'}">
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
								<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
				</c:if>
				<c:if test="${cst.svr_satisfy=='2'}">
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
				</c:if>
				<c:if test="${cst.svr_satisfy=='1'}">
							<img src="${pageContext.request.contextPath}/images/star.jpg"
								class="star_pic" />
				</c:if>
				
				</td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<button class="common_button" onClick=help('');;
>
						帮助
					</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="common_button" onClick="back();">
						返回
					</button>
				</td>
			</tr>
		</table>
	</body>
	<script
		src="pageContext.getRequest().getContextPath()}/js/changetrcolor.js"
		type="text/javascript"></script>
</html>