<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
	function fun(){
		   
			alert("用户名或密码错误");
		
	}
</script> 
</head>
<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
    <div class="loginbody">  
    <span class="systemlogo"></span> 
    
       <%
          Object obj = request.getAttribute("flag");
          if(obj != null){   
        %>
        <div style="text-align:center;">
        <span style="font-size:15px;color:darkred;font-weight:bold;">用户名或密码错误</span>        
        </div>
       <%	  
          }
       %>
    <div class="loginbox loginbox2">
    <ul>
    <form action="user" method="post">
    <input type="hidden" name="oper" value="login"/>
    <li><input name="uname" type="text" class="loginuser" placeholder="请输入用户名" /></li>
    <li><input name="pwd" type="password" class="loginpwd"  placeholder="请输入用户名" /></li>
    <li class="yzm">
    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
    </li>
    <li><input name="" type="submit" class="loginbtn" value="登录"   /><label><a href="user/reg.jsp">注册新用户</a></label><label><a href="#">忘记密码？</a></label></li>
    
    </form>
    </ul>
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  <a href="http://www.uimaker.com">uimaker.com</a>	QQ:	1004611609</div> 
</body>

</html>
