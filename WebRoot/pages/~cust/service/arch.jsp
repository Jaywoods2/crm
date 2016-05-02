<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<link href="${pageContext.request.contextPath}/css/test1.css"
			rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/script/common.js"></script>
	</head>
	<body>

		<!--<div class="page_title">客户服务管理 &gt; 服务归档</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="reload();">查询</button>  
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
		<form
			action="${pageContext.request.contextPath}/pages/~cust/service/cst_service_findBycon3.action?curPage=1"
			method="post" name="frm">
			<table class="query_form_table" cellSpacing=1 cellPadding=1>
				<tr>
					<td width=100% height=30 align=left
						background="${pageContext.request.contextPath}/images/m_table_top.jpg"
						colspan="6">
						<strong>&nbsp;服务归档</strong>
					</td>
				</tr>
				<tr>
					<th height="28">
						客户
					</th>
					<td>
						<input type="text" name="con.svr_cust_name"
							value="${con.svr_cust_name }" />
					</td>
					<th height="28">
						概要
					</th>
					<td>
						<input type="text" name="con.svr_title" value="${con.svr_title }" />
					</td>
					<th height="28">
						服务类型
					</th>
					<td>
						<select name="con.svr_type" id="con.svr_type">
							<option value="">
								全部
							</option>
							<c:choose>
								<c:when test="${con.svr_type=='咨询'}">
									<option value="咨询" selected="selected">
										咨询
									</option>
								</c:when>
								<c:otherwise>
									<option value="咨询">
										咨询
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_type=='建议'}">
									<option value="建议" selected="selected">
										建议
									</option>
								</c:when>
								<c:otherwise>
									<option value="建议">
										建议
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_type=='投诉'}">
									<option value="投诉" selected="selected">
										投诉
									</option>
								</c:when>
								<c:otherwise>
									<option value="投诉">
										投诉
									</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<th height="22">
						创建日期
					</th>
					<td colspan="3">
						<input type="text" name="con.mindate" size="5"
							value="${con.mindate }">
						-
						<input type="text" name="con.maxdate" size="5"
							value="${con.maxdate }">
					</td>
					<th height="22">
						状态
					</th>
					<td>
						<select name="con.svr_status" id="con.svr_status">
							<option value="">
								全部
							</option>
							<c:choose>
								<c:when test="${con.svr_status=='新创建'}">
									<option value="新创建" selected="selected">
										新创建
									</option>
								</c:when>
								<c:otherwise>
									<option value="新创建">
										新创建
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_status=='已分配'}">
									<option value="已分配" selected="selected">
										已分配
									</option>
								</c:when>
								<c:otherwise>
									<option value="已分配">
										已分配
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_status=='已处理'}">
									<option value="已处理" selected="selected">
										已处理
									</option>
								</c:when>
								<c:otherwise>
									<option value="已处理">
										已处理
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_status=='已反馈'}">
									<option value="已反馈" selected="selected">
										已反馈
									</option>
								</c:when>
								<c:otherwise>
									<option value="已反馈">
										已反馈
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${con.svr_status=='已归档'}">
									<option value="已归档" selected="selected">
										已归档
									</option>
								</c:when>
								<c:otherwise>
									<option value="已归档">
										已归档
									</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
						<button class="common_button" onClick=help('');;
>
							帮助
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="common_button" onClick=reload();;>
							查询
						</button>
					</td>
				</tr>
			</table>
		</form>
		<br />
		<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
			<TD class="page_title">
				检索结果
			</TD>
			<TD class="page_title_middle">
				&nbsp;
			</TD>
			<TD width=3>
				<IMG height=32
					src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3>
			</TD>
		</table>
		<table id="data_list_table" class="data_list_table" cellSpacing=1
			cellPadding=1>
			<tr>
				<th id="firstth">
					编号
				</th>
				<th>
					客户
				</th>
				<th>
					概要
				</th>
				<th>
					服务类型
				</th>
				<th>
					创建人
				</th>
				<th>
					创建日期
				</th>
				<th>
					状态
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${requestScope.res}" var="cs">
				<tr>
					<td class="list_data_number">
						${cs.svr_id}
					</td>
					<td class="list_data_text">
						${cs.svr_cust_name }
					</td>
					<td class="list_data_ltext">
						${cs.svr_title}
					</td>
					<td class="list_data_text">
						${cs.svr_type }
					</td>
					<td class="list_data_text">
						${cs.svr_create_by }
					</td>
					<td class="list_data_text">
						${cs.svr_create_date }
					</td>
					<td class="list_data_text">
						${cs.svr_status }
					</td>
					<td>
						<c:choose>
							<c:when test="${sessionScope.user.usr_role_id<=3}">

								<a
									href="${pageContext.request.contextPath}/pages/~cust/service/cst_service_queryResult?cs.svr_id=${cs.svr_id}">
									<img
										src="${pageContext.request.contextPath}/images/bt_detail.gif"
										class="op_button" /> </a>
							</c:when>
							<c:otherwise>
								<p align="center"
									style="color: red; margin-top: 200px; font-size: 20px">
									Sorry,you don't have the right to check the archived
									information.
								</p>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="7" class="pager">
					<div class="pager">

						<a
							href="${pageContext.request.contextPath}/${findBycon3 }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=1">首页</a>
						<c:choose>
							<c:when test="${curPage>1}">
								<a
									href="${pageContext.request.contextPath}/${findBycon3 }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${curPage-1}">上一页</a>
							</c:when>
							<c:otherwise>
															上一页
														</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${curPage<pages}">
								<a
									href="${pageContext.request.contextPath}/${findBycon3 }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${curPage+1}">下一页</a>
							</c:when>
							<c:otherwise>
															下一页
														</c:otherwise>
						</c:choose>

						<a
							href="${pageContext.request.contextPath}/${findBycon3 }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${pages}">尾页</a>

					</div>
				</th>
			</tr>
		</table>
	</body>

</html>