<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#role_excel_submit").click(function(){
		$('#role_excel_form').form('submit', {    
		    url:"role_excel",    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){
		    	alert(data);
		       	if(data=="success"){
		       		$.messager.show({
		       			title:'系统消息',
		       			msg:'导出成功',
		       			timeout:3000,
		       			showType:'slide'
		       		});
		       		//弹出框关闭
		       		$("#role_dialog").dialog("close");
		       		$('#role_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","导出失败,请重新导出");
		       	}
		    }    
		}); 
	})
	
	$("#role_excel_cancel").click(function(){
		//弹出框关闭
   		$("#role_dialog").dialog("close");
   		
	})
});
</script>
<form action="" method="post" id="role_excel_form">
<div align="center">
<table>
	<tr>
		<td colspan="3" style="font-size: 15px"><strong>确认是否导出到excel?</strong></td>
		
	</tr>
	<tr>
		<td ></td>	
	</tr>
	<tr>
		<td ></td>	
	</tr>
	<tr>
		
		<td > 
		<a id="role_excel_submit" href="#" class="easyui-linkbutton" >导出</a> 
		</td>
		<td><a id="role_excel_cancel" href="#" class="easyui-linkbutton" >取消</a></td>	
	</tr>
</table>
</div>	
</form>
</body>
</html>