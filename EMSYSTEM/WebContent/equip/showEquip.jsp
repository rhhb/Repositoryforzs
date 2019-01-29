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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
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
 <%
        String exportToExcel = request.getParameter("exportToExcel");
        if (exportToExcel != null
                && exportToExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "excel.xls");
 
        }
    %>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/EMSYSTEM/main/main.jsp" target="_parent">首页</a></li>
    <li><a href="equip?oper=showAll">设备信息查询</a></li>
    <li><a href="equip?oper=showAll">所有设备信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
     <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>    
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>  
    </div>
  
    <table class="tablelist">
    	<thead>
    	<tr>
    	<th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>id<i class="sort"><img src="images/px.gif" /></i></th>
        <th>设备编码</th>
        <th>创建日期</th>
        <th>设备名称</th>
        <th>规格型号</th>
        <th>生产厂家</th>
        <th>管理级别</th>
        <th>部门名称</th>
        <th>出厂编号</th>
        <th>出厂日期</th>
        <th>投产日期</th>
        <th>使用情况</th>
        <th>现状</th>
        <th>安装地点</th>       
        </tr>      
        </thead>
			<c:forEach items="${pageinfo.list}" var="equip_tabie">
        	  <tr>
        	  <td><input name="" type="checkbox" value="" /></td>
              <td>${equip_tabie.id}</td>
              <td>${equip_tabie.unifiedcode}</td>
              <td>${equip_tabie.createdate}</td>
              <td>${equip_tabie.equipname}</td>
              <td>${equip_tabie.models}</td>
              <td>${equip_tabie.product}</td>
              <td>${equip_tabie.supervisory_level}</td>
              <td>${equip_tabie.deptname}</td>
              <td>${equip_tabie.manufacture_number}</td>
              <td>${equip_tabie.manufacture_date}</td>
              <td>${equip_tabie.commissioning_date}</td>
              <td>${equip_tabie.use_info}</td>
              <td>${equip_tabie.now_status}</td>
              <td>${equip_tabie.installation_site}</td>       
              </tr>  
              </c:forEach> 
        </table>
        <div class="pagin">
	    	<div class="message">共<i class="blue">${count}</i>条记录，当前显示第&nbsp;<i class="blue">${pageinfo.pageNumber}&nbsp;</i>页</div>
	        <ul class="paginList">
	        <li class="paginItem"><a href="showpage?pageSize=${pageinfo.pageSize }&pageNumber=${pageinfo.pageNumber-1}" <c:if test="${pageinfo.pageNumber<=1 }">onclick="javascript:return false;"</c:if> ><span class="pagepre"></span></a></li>
	        <li class="paginItem"><a href="javascript:;">1</a></li>
	        <li class="paginItem current"><a href="javascript:;">2</a></li>
	        <li class="paginItem"><a href="javascript:;">3</a></li>
	        <li class="paginItem"><a href="javascript:;">4</a></li>
	        <li class="paginItem"><a href="javascript:;">5</a></li>
	        <li class="paginItem more"><a href="javascript:;">...</a></li>
	        <li class="paginItem"><a href="javascript:;">10</a></li>
	        <li class="paginItem"><a href="showpage?pageSize=${pageinfo.pageSize }&pageNumber=${pageinfo.pageNumber+1}" <c:if test="${pageinfo.pageNumber>=pageinfo.total}">onclick="javascript:return false;"</c:if>><span class="pagenxt"></span></a></li>
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
	
	 <%
        if (exportToExcel == null) {
    %>
    <a href="main/main.jsp?exportToExcel=YES">Export to Excel</a>
    <%
        }
    %>
	
</body>

</html>
  