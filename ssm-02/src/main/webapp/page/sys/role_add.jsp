<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#role_add_submit").click(function(){
		$('#role_add_form').form('submit', {    
		    url:"roleAdd",    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		       	if(data==1){
		       		$.messager.show({
		       			title:'系统消息',
		       			msg:'新增成功',
		       			timeout:3000,
		       			showType:'slide'
		       		});
		       		//弹出框关闭
		       		$("#role_dialog").dialog("close");
		       		$('#role_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","新增失败,请重新操作");
		       	}
		    }    
		}); 
	})
});
</script>
<div  style="padding:10px;">
系统设置 >> 角色管理
<hr/>
<div align="center">
<form action="" method="post" id="role_add_form">
<table>
	<tr>
		<td>角色名称:</td>
		<td><input type="text" name="name"/> </td>
	</tr>
	<tr>
		<td>角色排序:</td>
		<td><input type="text" name="sort"/> </td>
	</tr>
	<tr>
		<td>角色备注:</td>
		<td><input type="text" name="remark"/> </td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td>
		</td>		
		<td >
		<div align="center">
		<a  id="role_add_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a> 
		</div> 
		</td>
	</tr>
</table>

</form>

</div>
</body>
</html>