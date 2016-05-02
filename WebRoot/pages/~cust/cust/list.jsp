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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
	
	
	<script src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
	<script src="${pageContext.request.contextPath}/script/common.js" charset="utf-8"></script>
	<script type="text/javascript">
	function delcust1(msg,cust_id){
			if (window.confirm("确认删除"+msg+"吗？")){
				$("#cust_id_hid").val(cust_id);
				$("#delcstform").submit();
			}			
		}
	function conquery(){
		$("#conqueryform").submit();
	}
	</script>

  </head>
  
  <body>
  <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
  <tr>
   <td class="page_title">客户信息管理</td>
   <td class="page_title_middle">&nbsp;</td>
   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
</tr>
</table>
<form action="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action" method="post" id="conqueryform">
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>客户编号</th>
		<td><input type="text" name="con.cust_no"/></td>
		<th>名称</th>
		<td><input type="text" name="con.cust_name"/></td>
		<th>地区</th>
		<td>
			<select name="con.cust_addr">
				<option value="">全部</option>
				<option value="北京">北京</option>
				<option value="华北">华北</option>
				<option value="中南">中南</option>
				<option value="东北">东北</option>
				<option value="西部">西部</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td><input type="text" name="con.cust_manager_name"/></td>
		<th>客户等级</th>
		<td>
			<select name="con.cust_level_label">
				<option value="">全部</option>
				<option value="战略合作伙伴">战略合作伙伴</option>
				<option value="合作伙伴">合作伙伴</option>
				<option value="大客户">大客户</option>
				<option value="普通客户">普通客户</option>
			</select>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
    	<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
        	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="common_button" onClick="conquery()">查询</button> 
        </td>
    </tr>
</table>
</form>
<br />
<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
<tr>
   <td class="page_title">检索结果</td>
   <td class="page_title_middle">&nbsp;</td>
   <td width=3><IMG height=32 src="${pageContext.request.contextPath}/images/m_mpr.gif" width=3></td>
</tr>
</table>
<table id="data_list_table" class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th id="firstth">序号</th>
		<th>客户编号</th>
		<th>名称</th>
		<th>地区</th>
		<th>客户经理</th>
		<th>客户等级</th>
		<th>操作</th>
	</tr>
	<s:iterator value="cslist" var="cst">
	<tr>
		<td class="list_data_number"><s:property value="cust_id"/></td>
		<td class="list_data_text"><s:property value="cust_no"/></td>
		<td class="list_data_ltext"><s:property value="cust_name"/></td>
		<td class="list_data_text"><s:property value="cust_region"/></td>
		<td class="list_data_text"><s:property value="cust_manager_name"/></td>
		<td class="list_data_text"><s:property value="cust_level_label"/></td>
		<td class="list_data_op">
			<!-- 状态为0的客户不能被编辑 -->
			<c:choose>
				<c:when test="${cst.cust_status=='1'}">
					<img onClick="to('${pageContext.request.contextPath }/pages/~cust/cust/editquery.action?cust_id=<s:property value="cust_id"/>');" title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" />
				</c:when>
				<c:otherwise>
				<img title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.png" class="op_button" />
				</c:otherwise>
			</c:choose>
			<img onClick="to('${pageContext.request.contextPath }/pages/~cust/cust/editlkm.action?cust_id=<s:property value="cust_id"/>');" title="联系人" src="${pageContext.request.contextPath}/images/bt_linkman.gif" class="op_button" />
			<img onClick="to('${pageContext.request.contextPath }/pages/~cust/cust/atvalist.action?cust_id=<s:property value="cust_id"/>');" title="交往记录" src="${pageContext.request.contextPath}/images/bt_acti.gif" class="op_button" />
			<img onClick="to('${pageContext.request.contextPath }/pages/~cust/cust/orderlist.action?cust_id=<s:property value="cust_id"/>');" title="历史订单" src="${pageContext.request.contextPath}/images/bt_orders.gif" class="op_button" />
			<!-- 经理只能删除属于自己的客户 -->
			<c:choose>
				<c:when test="${sessionScope.user.usr_id==cst.cust_manager_id}">
					<img onClick="delcust1('“客户：<s:property value="cust_name"/>”',<s:property value="cust_id"/>);" title="删除" src="${pageContext.request.contextPath}/images/bt_del.gif" class="op_button" />
				</c:when>
				<c:otherwise>
					<img title="删除" src="${pageContext.request.contextPath}/images/bt_del.png" class="op_button" />
				</c:otherwise>
			</c:choose>
			
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="100" class="pager">
<div class="pager">
	共<s:property value="rows"/>条记录 每页 2 条
	第<s:property value="curpage"/>页
	<a href="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action?curpage=1">首页</a>
	<s:if test="curpage-1>0">
	<a href="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action?curpage=${curpage-1}">上一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">上一页</font>
	</s:else>
	
	<s:if test="pgs-curpage>0">
	<a href="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action?curpage=${curpage+1}">下一页</a>
	</s:if>
	<s:else>
	<font color="#ABA8AB">下一页</font>
	</s:else>
	<a href="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action?curpage=${pgs}">尾页</a>
	<form action="${pageContext.request.contextPath }/pages/~cust/cust/cstquery.action" method="post">
	转到<input value="<s:property value="curpage"/>" size="1" name="curpage" id="curpages"/>页
	<input  type="submit" value="GO"/>
</form>
</div>
		</th>
	</tr>
</table>
			<form action="${pageContext.request.contextPath }/pages/~cust/cust/editdelcst.action" method="post" id="delcstform">
				<input type="hidden" name="cust_id" value="" id="cust_id_hid"/>
			</form>
</body>
<script src="${pageContext.request.contextPath}/js/changetrcolor.js" type="text/javascript"></script>
 
</html>
