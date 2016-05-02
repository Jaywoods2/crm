<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Integer pages = (Integer) request.getAttribute("pages");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>服务分配</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${pageContext.request.contextPath}/css/test1.css"
			rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/script/common.js"></script>
	</head>

    <script type="text/javascript">
      function del(){
        if(!confirm("确认要删除吗？")){
          window.event.returnValue=false;
        }
      }
    </script>
	<script type="text/javascript">
     function myurl(){
     window.location.href = "${pageContext.request.contextPath}/pages/~cust/service/cst_service_updateinfo.action";
     }
    </script>
	<body>
		<br>
		<br>
		<!--<div class="page_title">客户服务管理 > 服务分配</div>
<div class="button_bar">
	<button class="common_button" onClick="help('');">帮助</button>
	<button class="common_button" onClick="reload();">查询</button>  
</div>-->
		<form
			action="${pageContext.request.contextPath}/pages/~cust/service/cst_service_findBycon.action?curPage=1"
			method="post" name="frm">

			<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
				<TD class="page_title">
					客户服务管理
				</TD>
				<td class="page_title_middle">
					&nbsp;
				</td>
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
						<strong>&nbsp;服务分配</strong>
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
						<input type="text" name="con.svr_status" value="新创建" />
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
					分配给
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
						<c:choose>
							<c:when test="${sessionScope.user.usr_role_id<=2}">
								<form
									action="${pageContext.request.contextPath}/pages/~cust/service/cst_service_updateinfo.action"
									method="post" name="frm">
									<input type="hidden" value="${cs.svr_id }" name="cs.svr_id">
									<select name="cs.svr_due_to" id="cs.svr_due_to">
										<s:iterator value="sys">
											<option value="<s:property />">
												<s:property />
											</option>
										</s:iterator>
									</select>
									<input type="hidden" name="cs.svr_status" id="cs.svr_status" />
									<input type="hidden" id="cs.svr_due_date"
										name="cs.svr_due_date">
									<input type="submit" value="分配" name="">
								</form>
							</c:when>
							<c:otherwise>

								<input type="hidden" value="${cs.svr_id }" name="cs.svr_id">
								<select name="cs.svr_due_to" id="cs.svr_due_to"
									disabled="disabled">
									<option value="">
										请选择..
									</option>
								</select>
							</c:otherwise>
						</c:choose>

					</td>
					<td class="list_data_op">

						<a
							href="${pageContext.request.contextPath}/pages/~cust/service/cst_service_deleteinfo.action?cs.svr_id=${cs.svr_id}"><img
								title="删除"
								src="${pageContext.request.contextPath}/images/bt_del.gif"
								class="op_button" onclick="del()"/> </a>

					</td>
				</tr>
			</c:forEach>

			<tr>
				<th colspan="8" class="pager">
					<div class="pager">
						
						<a
							href="${pageContext.request.contextPath}/${findBycon }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=1">首页</a>
						<c:choose>
							<c:when test="${curPage>1}">
								<a
									href="${pageContext.request.contextPath}/${findBycon }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${curPage-1}">上一页</a>
							</c:when>
							<c:otherwise>
															上一页
														</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${curPage<pages}">
								<a
									href="${pageContext.request.contextPath}/${findBycon }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${curPage+1}">下一页</a>
							</c:when>
							<c:otherwise>
															下一页
														</c:otherwise>
						</c:choose>

						<a
							href="${pageContext.request.contextPath}/${findBycon }?con.svr_cust_name=${con.svr_cust_name }&con.svr_title=${con.svr_title }&con.svr_type=${con.svr_type}&con.mindate=${con.mindate}&con.maxdate=${con.maxdate}&con.svr_status=${con.svr_status}&curPage=${pages}">尾页</a>
						
					</div>
				</th>
			</tr>
		</table>

	</body>

</html>