<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	 <base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic ValidateBox - jQuery EasyUI Demo</title>
	<script type="text/javascript" src="WEB-INF/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="WEB-INF/css/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<!-- 	<link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<!-- 	<script type="text/javascript" src="js/jquery.js"></script> -->
</head>
<script type="text/javascript">


$(function(){
	$("#deptname").change(function(){
		alert($("#deptname").val());
		$("#deptno").val($("#deptname").val());
	});
	$("#fm").submit(function(){
		if($("#unifiedcode").val()==""){
			alert("设备编码不能为空");
			return false;
// 		}else if($("#createdate").datebox("getValue")==""){
// 			var date =$("#createdate").datebox("getValue"); 
			
// 			alert("创建日期不能为空");
// 			return false;
		
// 		}else if($("#equipname").val()==""){
// 			alert("设备名称不能为空");
// 			return false;
		
// 		}else if($("#models").val()==""){
// 			alert("设备型号不能为空");
// 			return false;
		
// 		}else if($("#product").val()==""){
// 			alert("厂家名称不能为空");
// 			return false;
		
		}
		else{
			return true;
		}
	})
});
</script>
<body>
    <div align="center">
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="设备登记" style="width:950px;padding:10px 60px 20px 60px;">
	<form action="equip" method="post" id="fm">
		<input type="hidden" name="oper" value="addequip" />
		<table cellpadding="3">
		<tr>
			<td>设备编码：</td>
			<td><input type="text" name="unifiedcode" id="unifiedcode"/></td> 
			<td>创建日期：</td>
			<td><input class="easyui-datebox textbox"  name="createdate" id="createdate" ></td> 			
		</tr>
		<tr>
			<td>设备名称：</td>
			<td><input type="text" name="equipname" id="equipname" ></td> 
			<td>规格型号：</td>
			<td><input type="text" name="models" id="models" ></td>
			
			 			
		</tr>
		<tr>
			<td>厂家名称：</td>
			<td><input type="text" name="product" id="product" ></td> 
			<td>管理级别：</td>
			<td><select name="supervisory_level" id="supervisory_level">
				<option value="A">A</option>
				<option value="A">B</option>
				<option value="A">C</option>
	            </select></td> 			
		</tr>		
		<tr>
			<td>部门名称：</td>
			
			<td><select name="deptname" id="deptname" >
			<c:forEach items="${list }" var="dept">
				<option value="${dept.deptName}">${dept.deptName}</option>
				 </c:forEach> 
	            </select></td>
	           
			<td>设备编号：</td>
			<td><input type="text" name="manufacture_number" id="manufacture_number" ></td> 
			<td>出厂日期：</td>
			<td><input class="easyui-datebox textbox"  name="manufacture_date" id="manufacture_date" ></td>			
		</tr>
		<tr>
			<td>投产日期：</td>			
			<td><input class="easyui-datebox textbox"  name="commissioning_date" id="commissioning_date" ></td>  
			<td>使用信息：</td>
			<td><input type="text" name="use_info" id="use_info" ></td> 
			<td>现状：</td>
			<td><input type="text"  name="now_status" id="now_status" ></td>			
		</tr>
		<tr>
			<td>安装地点：</td>			
			<td><input type="text"  name="installation_site" id="installation_site" ></td>  
			<td>原值：</td>
			<td><input type="text" name="original_value" id="original_value" value="0.00"></td> 
			<td>折旧率：</td>
			<td><input type="text"  name="depreciation_rate" id="depreciation_rate" ></td>			
		</tr>
		<tr>
			<td>使用年限：</td>			
			<td><input type="text"  name="durable_year" id="durable_year" >年</td>  
			<td>设计能力：</td>
			<td><input type="text" name="design_capability" id="design_capability" ></td> 
			<td>使用情况：</td>
			<td><input type="text"  name="equip_use" id="equip_use" ></td>

		</tr>
		<tr>
			<td>标记：</td>			
			<td><input type="text"  name="sign" id="sign" ></td>  
			<td>技术参数：</td>
			<td><input type="text" name="technical_paraments" id="technical_paraments" ></td> 
			<td>附属设备：</td>
			<td><input type="text"  name="accessory_equipment" id="accessory_equipment" ></td>
		</tr>
		<tr>
			<td>附属设备更换：</td>			
			<td><input type="text"  name="accessory_equipment_change" id="accessory_equipment_change" ></td>  
			<td>随机资料：</td>
			<td><input type="text" name="attach_documentation" id="attach_documentation" ></td> 
			<td>异动记录：</td>
			<td><input type="text"  name="change_info" id="change_info" ></td>
		</tr>
		<tr>
			<td>配件型号：</td>			
			<td><input type="text"  name="parts_model" id="parts_model" ></td>  
			<td>维修记录：</td>
			<td><input type="text" name="service_record" id="service_record" ></td> 
			<td>报废记录：</td>
			<td><input type="text"  name="scrap_sign" id="scrap_sign" ></td>
		</tr>
		<tr>
			<td>部门编号：</td>			
			<td><input type="text" name="deptno" id="deptno" ></td>
			<td>替代编号：</td>			
			<td><input type="text" name="change_unifiedcode" id="change_unifiedcode"  ></td>	
		</tr>
		<tr>
			<td colspan="6" align="center"> <input type="submit" value="新增" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
			
		</tr>
		</table>
		</form>
	</div>
	</div>
	
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>

</body>
</html>