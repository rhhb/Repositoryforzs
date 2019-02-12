<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>至尊管理系统</title>
</head>
<body>
<script type="text/javascript">
function abc(obj){
	$('#role_dialog').dialog({    
	    title: '分配权限',    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: 'sys/privilege.jsp',    
	    modal: true,
	    onLoad:function(){
	    	/* $("#role_edit_form :text:eq(0)").val($("#role_table").datagrid("getSelected").name);
	    	$("#role_edit_form :text:eq(1)").val($("#role_table").datagrid("getSelected").sort);
	    	$("#role_edit_form :text:eq(2)").val($("#role_table").datagrid("getSelected").remark);
	    	$("#role_edit_form :hidden:eq(0)").val($("#role_table").datagrid("getSelected").id); */
	    	$("#privilege_form :hidden:eq(0)").val($(obj).parent().parent().siblings("[field='id']").children().eq(0).html());
	    	$('#privilege_tree').tree({    
	    	    url:'showPrivilege?id='+$(obj).parent().parent().siblings("[field='id']").children().eq(0).html(),
	    	    checkbox:true		
	    	}); 
	    }
	}); 
}

$(function(){
	$('#role_table').datagrid({    
	    url:'showRole',    
	    columns:[[    
	        {field:'id',title:'编号',width:100,hidden:true},    
	        {field:'name',title:'角色名称',width:100},    
	        {field:'sort',title:'排序id',width:100,align:'right'},    
	        {field:'remark',title:'备注',width:100,align:'right'},
	        {field:'qwe',title:'操作',width:100,align:'right',
	        	formatter: function(value,row,index){
					return "<a href='javascript:void(0)' onclick='javascript:abc(this);return false;'>分配权限</a>";
				}
	        }
	    ]],
	    pagination:true,
	    pageList:[2,4,6],
	    fitColumns:true,
	    striped:true,
	    rownumbers:true,
	    toolbar: [{
			iconCls: 'icon-add',
			text:'增加',
			handler: function(){
				if($("#role_table").datagrid("getSelections").length==0){
					$('#role_dialog').dialog({
						title: '新增角色',
						width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,
						href: 'sys/role_add.jsp',
						modal: true
					});
				}else{
					$.messager.alert("系统信息","请勿选择<b style='color:red;'>行</b>")
				}
				
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				if($("#role_table").datagrid("getSelections").length>0){
					var data = $("#role_table").datagrid("getSelections");
					if(data.length>0){
						$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
						    if (r){ 
						    	var rid=[];
                                for(var i=0;i<data.length;i++)
                                    {
                                    rid[i]=data[i].id;
                                    }                               
//                                 $.ajax({
//                                 	type:"post",
//                                 	url:"roleRemove",
//                                 	data:'{"rid":rid}',
//                                 	contextType:"application/json;charset=utf-8",
//                                 	success:function(data){
//                                 		alert(data.rid);
//                                 	}
//                                 });
                                
                                
//                                 $.post("roleRemove",data,
// 							          function(data){
// 							          alert(data); // John							          
// 							          //  2pm
// 							          }, "json")
                                
                                $.get("roleRemove?rid="+rid,
                                        function(rtn){
//                                 	alert(rtn);
//                                     var msg=eval("("+rtn+")");
                                    
                                    if(rtn>0)                                       
                                    $('#role_table').datagrid('reload');                                       
                                    $.messager.show({title:"提示",msg:'删除成功'});                                
                                });
						           
						    }    
						});
					}
				}
				
				else{
					$.messager.alert("系统信息","请选择删除<b style='color:red;'>行</b>")
				}   
					
				
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				if($("#role_table").datagrid("getSelections").length==1){
					//弹出窗口
					$('#role_dialog').dialog({    
					    title: '修改角色',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					    href: 'sys/role_edit.jsp',    
					    modal: true,
					    onLoad:function(){
					    	$("#role_edit_form :text:eq(0)").val($("#role_table").datagrid("getSelected").name);
					    	$("#role_edit_form :text:eq(1)").val($("#role_table").datagrid("getSelected").sort);
					    	$("#role_edit_form :text:eq(2)").val($("#role_table").datagrid("getSelected").remark);
					    	$("#role_edit_form :hidden:eq(0)").val($("#role_table").datagrid("getSelected").id);
					    }
					}); 
				}else{
					$.messager.alert("系统信息","请选择<b style='color:red;'>一行</b>")
				}
			}
		},'-',{
			iconCls: 'icon-excel',
			text:'导出excel',
			handler: function(){
				if($("#role_table").datagrid("getSelections").length==0){
					$('#role_dialog').dialog({
						title: '导出excel',
						width: 200,    
					    height: 120,    
					    closed: false,    
					    cache: false,
						href: 'sys/role_excel.jsp',
							modal: true
					});
				}else{
					$.messager.alert("系统信息","请勿选择<b style='color:red;'>行</b>")
				}
					
				
				
// 					alert('正在建设中')
// 				var info=$("#role_table").datagrid("getData");
				//这里举例获取某列所有数据的和，当然你也可以进行其它处理或遍历操作
// 				var total=0;
// 				for(var i=0;i<info.rows.length;i++){
// 					total=info.rows[i].name;  //假设Table中有列名number
// 					alert(total);
// 				}
// 				$("#AllAmount").text("total")


				
			}
		}]

	});
})
</script>
<table id="role_table"></table> 


<div id="role_dialog">Dialog Content.</div>  
</body>
</html>