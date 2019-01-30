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
	var unifiedcode1 = $("#unifiedcode").val();
	alert(unifiedcode);
	var equipname = $("#equipname").val();
	alert(equipname);
	var deptname= $("#deptname").val();
	alert(deptname);
	
	
	
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
				alert(json);
				
				
// 				eval("var equipTable="+json);
// 				alert(equipTable.unifiedcode);
// 					var ta=document.getElementById("ta");
// 						ta.innerHTML="";
// 						var tr=ta.insertRow(0);
// 						var cell0=tr.insertCell(0);
// 						cell0.innerHTML="编号";
// 						var cell1=tr.insertCell(1);
// 						cell1.innerHTML="名称";
// 						var cell2=tr.insertCell(2);
// 						cell2.innerHTML="年龄";
						
						//插入新的行
						
// 						var tr=ta.insertRow(1);
// 						var cell0=tr.insertCell(0);
// 							cell0.innerHTML=equipTable.id;
// 						var cell1=tr.insertCell(1);
// 						cell1.innerHTML=equipTable.unifiedcode;
// 						var cell2=tr.insertCell(2);
// 						cell2.innerHTML=equipTable.createdate;
						
			}	
		}	
	}
	//发送请求
//			get方式:请求实体拼接在URL后面
			ajax.open("get","equip?oper=queryequip&deptname="+deptname);
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



$(function(){    
    var sherchkey='${positioninfo.name}';
    savePosition();//保存修改方法
    getPeopleList(1,5,sherchkey);//获取人才列表 
   // getPageList(); //分页方法
});


//自己封装获取数据方法
function getPeopleList(crr,lmt,searchKey){
  //获取人才列表
   $.ajax({
            url:'${ctx}/recruit/peoplelist',
            type:'post',
            data:{
                   "curr":crr||1,
                   "pageSize":lmt||5,
                   "searchKey":searchKey
                 },
            dataType:'json',
            success:function(res){
                if(res.success=="success"){
                    console.log(res);
                    count=res.data.totalElements;//总记录
                    curr=res.data.number; //当前页
                    limit=res.data.size; //每页几个
                    var rclist=res.data.content;
                    var html='';
                    var len=rclist.length;
                    
                    for (var i=0; i<len; i++){
                        var htmlbuf='<tr>'+
                           '<td style="text-align:center">'+rclist[i].name+'</td>'+
                           '<td style="text-align:center">'+rclist[i].edu+'</td>'+
                           '<td style="text-align:center">'+rclist[i].skill+'</td>'+
                           '<td style="text-align:center">'+rclist[i].exp+'</td>'+
                           '<td style="text-align:center">'+rclist[i].add+'</td>'+
                           '<td style="text-align:center">'+rclist[i].tel+'</td>'+
                           '</tr>';
                         html=html+htmlbuf; 
                    }
                    $("#rcktb").html(html);
                    //调用分页方法
                    getPageList(count,curr,limit,searchKey);
                     
                }else {
                    layer.alert(res.message);
                }
            },
            error:function(){
                layer.msg("网络故障");
            }
        })
}


//自己封装分页方法
function getPageList(count,curr,limit,searchKey){
 //分页方法
  layui.use(['laypage', 'layer'], function(){
    var laypage = layui.laypage
    ,layer = layui.layer;
    //完整功能
    laypage.render({
      elem: 'pagefenye',
      count: count||0,
      theme: '#009587',
      limit : limit||3,
      limits:[5, 10, 20, 30, 40],
      curr : curr||1,
      layout: ['count', 'prev', 'page', 'next',  'refresh', 'skip'],
      jump: function(obj,first){
      //debugger;
          if(!first){
              //window.location.href = "?curr="+obj.curr+"&pageSize="+obj.limit+"&enterId="+'${enterId}';
              getPeopleList (obj.curr,obj.limit,searchKey);
          }
      }
    });
  });
}



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
			<c:forEach items="${list }" var="dept">
				<option value="${dept.deptName}">${dept.deptName}</option>
				 </c:forEach> 
	            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" class="sure" value="搜索" onclick="getData()"/>
    
  <div class="rctj-box ${(detailflg=='detailflg')?'':'layui-hide'} ">
            <div style="margin-top: 25px">人才推荐</div>
            <div class="rctj"  style="margin-top: 10px;padding: 20px;background-color: #F2F2F2;" > 
                 <table class="layui-table">
                      <colgroup>
                        <col width="150">
                        <col width="200">
                        <col>
                      </colgroup>
                      <thead>
                        <tr id="rckth">
                          <th style="text-align:center">设备编码</th>
                          <th style="text-align:center">创建日期</th>
                          <th style="text-align:center">设备名称</th>
                          <th style="text-align:center">规格型号</th>
                          <th style="text-align:center">生产厂家</th>
                          <th style="text-align:center">管理级别</th>
                          <th style="text-align:center">部门名称</th>
                          <th style="text-align:center">出厂编号</th>
                          <th style="text-align:center">出厂日期</th>
                          <th style="text-align:center">投产日期</th>
                        </tr> 
                      </thead>
                      <tbody id="rcktb">
                      
                      </tbody>
                    </table>
             </div>
                    <div id="pagefenye" class="fenye" style="text-align:center;"></div>
         </div>  
    
    

    
    </div>
    <div style="width: 80%;padding-top: 20px">
    
   
			
			
			
		
    
    <table class="tablelist" id="">

	</table>
        </div>
        <div id="pageBar"></div>
        <div class="pagin">
	    	<div class="message">共<i class="blue">${count}</i>条记录，当前显示第&nbsp;<i class="blue">${pageinfo.pageNumber}&nbsp;</i>页</div>
	        <ul class="paginList">
	        <li class="paginItem"><a href="equip?oper=queryequip?pageSize=${pageinfo.pageSize }&pageNumber=${pageinfo.pageNumber-1}&unifiedcode=${pageinfo.unifiedcode}&equipname=${pageinfo.equipname}&deptname=${pageinfo.deptname}" <c:if test="${pageinfo.pageNumber<=1 }">onclick="javascript:return false;"</c:if> ><span class="pagepre"></span></a></li>
	        <li class="paginItem"><a href="javascript:;">1</a></li>
	        <li class="paginItem current"><a href="javascript:;">2</a></li>
	        <li class="paginItem"><a href="javascript:;">3</a></li>
	        <li class="paginItem"><a href="javascript:;">4</a></li>
	        <li class="paginItem"><a href="javascript:;">5</a></li>
	        <li class="paginItem more"><a href="javascript:;">...</a></li>
	        <li class="paginItem"><a href="javascript:;">10</a></li>
	        <li class="paginItem"><a href="equip?oper=queryequip?pageSize=${pageinfo.pageSize }&pageNumber=${pageinfo.pageNumber+1}&unifiedcode=${pageinfo.unifiedcode}&equipname=${pageinfo.equipname}&deptname=${pageinfo.deptname}" <c:if test="${pageinfo.pageNumber>=pageinfo.total}">onclick="javascript:return false;"</c:if>><span class="pagenxt"></span></a></li>
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
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script language="Javascript" src="js/layui.js"></script>
<script language="Javascript" src="js/nicePage.js"></script>
<script LANGUAGE="javascript">
	//标准json格式 目前只支持[{a:b,c:d},{a:b,c:d}]此种格式
	var json = ajax.responseText;
	alert(json);

	

	/**
	 * 初始化设置nicepage组件    v1.0
	 *-------------------------------------------------------------
	 * 进行数据组装,与layui交互进行元素渲染
	 *-------------------------------------------------------------
	 * @param    {string}  table     table的div id
	 * @param    {string}  bar     底部分页的div id
	 * @param    {int}  limit     每页默认行数
	 * @param    {string}  color     底部分页的颜色
	 * @param    {array}  layout     底部分页的布局,具体可参考layui api
	 *
	 * @date     2018-10-19
	 * @author   Thomas.dz <hzdz163@163.com>
	 */
	//nameList与widthList的数组长度要一致
		var nameList = ['设备编码', '创建日期', '设备名称', '规格型号', '生产厂家', '管理级别', '部门名称', '出厂编号', '出厂日期', '投产日期'] //table的列名
		var widthList = [100, 100, 100, 100, 100, 100, 100, 100, 100, 250] //table每列的宽度
		$(function () {
			nicePage.setCfg({
				table: 'table',
				bar: 'pageBar',
				limit: 20,
				color: '#1E9FFF',
				layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
			});
		});
	//初始化完成
</script>
</html>
  