

<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>后台管理系统</title>
	<base href="<%=basePath%>">
</head>
<body>
<script type="text/javascript">
	alert("${msg}") ;
	window.location = "<%=basePath%>${url}" ;
</script>
</body>
</html>
