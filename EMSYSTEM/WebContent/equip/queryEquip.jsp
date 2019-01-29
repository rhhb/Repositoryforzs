<%@ page language="java" import="java.util.*,com.bjsxt.pojo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/layui.css" type="text/css" rel="stylesheet">


<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
function getData(){
	//获取用户请求数据
	var datas={
		"unifiedcode":$("#unifiedcode").val(),
		"equipname":$("#equipname").val(),
		"deptname":$("#deptname").val(),
		"pageSize":"5",
		"pageNumber":$("#pageNumber").val()	
	};
   var data = JSON.stringify(datas);
	//创建ajax引擎对象
		var ajax;
		if(window.XMLHttpRequest){
			ajax=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			ajax=new ActiveXObject("Msxml2.XMLHTTP");
		}
	//复写onreadystatechange函数
	ajax.onreadystatechange=function(){
		//判断ajax状态码
		if(ajax.readyState==4){
			//判断响应状态码
			if(ajax.status==200){
				//获取响应内容
				var json=ajax.responseText;
				
				//处理响应内容
				eval("var map="+json);
				var pageSize = map.pageSize;				
				var pageNumber = map.pageNumber;
				var span2 =document.getElementById("showPageNumber");
					span2.innerHTML=pageNumber;
				var count = map.count;
				var span =document.getElementById("showtotal");
				span.innerHTML=count;
				var total = map.total;				
				
				var ep = map.list;
				var list = JSON.stringify(ep);				
				eval("var list=" +list);
				var len = list.length;				
				var tb=document.getElementById("tb");
				tb.innerHTML="";
// 				var tr=ta.insertRow(0);
// 				var cell0=tr.insertCell(0);
// 					cell0.innerHTML="设备编号";
// 				var cell1=tr.insertCell(1);
// 					cell1.innerHTML="创建日期";
// 				var cell2=tr.insertCell(2);
// 					cell2.innerHTML="设备名称";
// 				var cell3=tr.insertCell(3);
// 					cell3.innerHTML="型号规格";
// 				var cell4=tr.insertCell(4);
// 					cell4.innerHTML="生产厂家";
// 				var cell5=tr.insertCell(5);
// 					cell5.innerHTML="管理级别";
// 				var cell6=tr.insertCell(6);
// 					cell6.innerHTML="部门名称";
// 				var cell7=tr.insertCell(7);
// 					cell7.innerHTML="出厂编号";
// 				var cell8=tr.insertCell(8);
// 					cell8.innerHTML="出厂日期";
// 				var cell9=tr.insertCell(9);
// 					cell9.innerHTML="投产日期";		
				for (var i=0; i<len; i++){				
					//插入新的行					
					var tr=tb.insertRow(0);
					var cell0=tr.insertCell(0);
						cell0.innerHTML=list[i].unifiedcode;
					var cell1=tr.insertCell(1);
						cell1.innerHTML=list[i].createdate==undefined?"":list[i].createdate;
					var cell2=tr.insertCell(2);
						cell2.innerHTML=list[i].equipname==undefined?"":list[i].equipname;
					var cell3=tr.insertCell(3);
						cell3.innerHTML=list[i].models==undefined?"":list[i].models;
					var cell4=tr.insertCell(4);
						cell4.innerHTML=list[i].product==undefined?"":list[i].product;
					var cell5=tr.insertCell(5);
						cell5.innerHTML=list[i].supervisory_level==undefined?"":list[i].supervisory_level;
					var cell6=tr.insertCell(6);
						cell6.innerHTML=list[i].deptname==undefined?"":list[i].deptname;
					var cell7=tr.insertCell(7);
						cell7.innerHTML=list[i].manufacture_number==undefined?"":list[i].manufacture_number;
					var cell8=tr.insertCell(8);
						cell8.innerHTML=list[i].manufacture_date==undefined?"":list[i].manufacture_date;
					var cell9=tr.insertCell(9);
						cell9.innerHTML=list[i].commissioning_date==undefined?"":list[i].commissioning_date;
         
                }				
			}	
		}	
	}
	
	
	//发送请求
//			get方式:请求实体拼接在URL后面
			ajax.open("get","equip?oper=queryequip&data="+data);
			ajax.send(null); 
		//post方式：请求实体需要单独的发送
			/*ajax.open("post", "ajax");
			ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			ajax.send("name=张三");*/
    
}

 


	
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/EMSYSTEM/main/main.jsp" target="_parent">首页</a></li>
    <li><a href="equip?oper=showAll">信息查询</a></li>
    <li><a href="equip?oper=showAll">查询设备信息</a></li>
    </ul>
    </div>   
    <div class="rightinfo">
    <div align="center" style="margin: 8px,auto">
<!--    <form action="equip" method="post" id="fm" > -->
    <input type="hidden" name="oper" value="queryequip" />
    <label>设备编码：</label><input name="unifiedcode" id="unifiedcode" type="text" class="dfinput" />
    <label>设备名称：</label><input name="equipname" id="equipname" type="text" class="dfinput" />
     
          部门名称：<select name="deptname" id="deptname" class="dfinput">
			<option></option>
			<c:forEach items="${list }" var="dept">				
				<option value="${dept.deptName}">${dept.deptName}</option>
				 </c:forEach> 
	            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" class="sure" value="搜索" onclick="getData()"/>
    当前页<input type="text" id="pageNumber" name="pageNumber" class="dfinput" />

    
    
<!--     	<ul class="toolbar"> -->
<!--         <li class="click"><span><img src="images/t01.png" /></span>添加</li> -->
<!--         <li class="click"><span><img src="images/t02.png" /></span>修改</li> -->
<!--         <li><span><img src="images/t03.png" /></span>删除</li> -->
<!--         <li><span><img src="images/t04.png" /></span>统计</li> -->
<!--         </ul> -->
<!--         <ul class="toolbar1"> -->
<!--         <li><span><img src="images/t05.png" /></span>设置</li> -->
<!--         </ul> -->
    
    </div>
    <div  style="margin:10px auto; width:80%">
    

     	<table class="tablelist" id="ta" align="center">
   			<thead>
   				<tr>
   					<th>设备编号</th>
   					<th>创建日期</th>
   					<th>设备名称</th>
   					<th>规格型号</th>
   					<th>生产厂家</th>
   					<th>管理级别</th>
   					<th>部门名称</th>
   					<th>出厂编号</th>
   					<th>出厂日期</th>
   					<th>投产日期</th>   					
   				</tr>
   				
   			</thead>
   			<tbody id="tb">
   			</tbody>
        </table>
        </div>
        
        <div id="pageBar"></div>
        <div class="pagin" >
	    	<div class="message">共<i class="blue"><label id="showtotal"></label></i>条记录，当前显示第&nbsp;<i class="blue"><label id="showPageNumber"></label>&nbsp;</i>页</div>
	        <ul class="paginList" >
	        <li class="paginItem"><a href="" <c:if test="${map.pageNumber<=1 }">onclick="javascript:return false;"</c:if> ><span class="pagepre"></span></a></li>
	        <li class="paginItem"><a href="">1</a></li>
	        <li class="paginItem current"><a href="">2</a></li>
	        <li class="paginItem"><a href="javascript:;" onclick="getData()" id="pageNumber" value="3">3</a></li>	        
	        <li class="paginItem"><a href="javascript:;">4</a></li>
	        <li class="paginItem"><a href="javascript:;">5</a></li>
	        <li class="paginItem more"><a href="javascript:;">...</a></li>
	        <li class="paginItem"><a href="javascript:;">10</a></li>
	        <li class="paginItem"><a href="equip?oper=queryequip" <c:if test="${map.pageNumber>=map.total}"> onclick="javascript:return false;"</c:if>><span class="pagenxt"></span></a></li>
	        </ul>
	       
       </div>
       
        <div class="tip">
	    	<div class="tiptop"><span>提示信息</span><a></a></div>
	        
	        <div class="tipinfo">
	        <span><img src="images/ticon.png" /></span>
	        <div class="tipright">
	        <p>是否确认对信息的修改 ？</p>
	        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
	        </div>
	        </div>
	        
	        <div class="tipbtn">
	        <input name="" type="button"  class="sure" value="确定" />&nbsp;
	        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    </div>

    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
  