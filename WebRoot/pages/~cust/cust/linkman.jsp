<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系人</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath}/css/test1.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/script/common.js"></script>
<script src="${pageContext.request.contextPath}/script/jquery-1.4.1.js"></script>
	<script type="text/javascript">
	function dellkm(msg,lkm_id,cust_id){
		if (window.confirm("确认删除"+msg+"吗？")){
			$("#lkm_id_hid").val(lkm_id);
			$("#cust_id_hid").val(cust_id);
			$("#formId").submit();
		}
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
<table class="query_form_table" cellSpacing=1 cellPadding=1>
	<tr>
    	<td  width=100% height=30 align=left background = "${pageContext.request.contextPath}/images/m_table_top.jpg" colspan="6"><strong>&nbsp;客户信息 > 联系人 </strong></td>
    </tr>
	<tr>
		<th>客户编号</th>
		<td><s:property value="cs.cust_no"/></td>
		<th>客户名称</th>
		<td><s:property value="cs.cust_name"/></td>
	</tr>
	<tr>
<td colspan="4" align="center">
	<button class="common_button" onClick="help('');">帮助</button>&nbsp;&nbsp;
	<button class="common_button" onClick="to('${pageContext.request.contextPath}/pages/~cust/cust/linkman_add.jsp?cust_id=<s:property value="cs.cust_id"/>');">新建</button>&nbsp;&nbsp;
	<button class="common_button" onClick="back();">返回</button>  
</td>
	</tr>
	</table>
	
<br />
<table class="data_list_table" cellSpacing=1 cellPadding=1>
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>职位</th>
		<th>办公电话</th>
		<th>手机</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="lkms">
	<tr>
		<td class="list_data_text"><s:property value="lkm_name"/></td>
		<td class="list_data_ltext"><s:property value="lkm_sex"/></td>
		<td class="list_data_text"><s:property value="lkm_postion"/></td>
		<td class="list_data_text"><s:property value="lkm_tel"/></td>
		<td class="list_data_text"><s:property value="lkm_mobile"/></td>
		<td class="list_data_op"><s:property value="lkm_memo"/>
			　</td>
		<td class="list_data_op">
			<img onClick="to('${pageContext.request.contextPath}/pages/~cust/cust/editlkmone.action?lkm_id=<s:property value="lkm_id"/>');" title="编辑" src="${pageContext.request.contextPath}/images/bt_edit.gif" class="op_button" />
			<img onClick="dellkm('“联系人：<s:property value="lkm_name"/>”',<s:property value="lkm_id"/>,<s:property value="cs.cust_id"/>);" title="删除" src="${pageContext.request.contextPath}/images/bt_del.gif" class="op_button" />		

		</td>
	</tr>
	</s:iterator>
	
	</table>
		<form action="${pageContext.request.contextPath}/pages/~cust/cust/editdellkm.action" method="post" id="formId">
				<input type="hidden" value="" name="lkm_id" id="lkm_id_hid"/>
				<input type="hidden" value="" name="cust_id" id="cust_id_hid"/>
			</form>
</body>
</html>