<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
function uploadFile() {
	var file = $("#upload").val();
	file = file.substring(file.lastIndexOf('.'), file.length);
	if (file == '') {
		alert("上传文件不能为空！");
	} else if (file != '.xlsx' && file != '.xls') {
		alert("请选择正确的excel类型文件！");
	} else {
		ajaxFileUpload();
	}
}
function ajaxFileUpload() {

	var formData = new FormData();
	var name = $("#upload").val();
	formData.append("file", $("#upload")[0].files[0]);
	formData.append("name", name);
	$.ajax({
		url : "/InputExcel",
		type : "POST",
		async : false,
		data : formData,
		processData : false,
		contentType : false,
		beforeSend : function() {
			console.log("正在进行，请稍候");
		},
		success : function(e) {
			if (e == "01") {
				alert("导入成功");
			} else {
				alert("导入失败");
			}
		}
	});
}

function OutputExce() {
	window.location.href = "/OutputExcel";
}
</script>
<body>
<table>
	<tr>
	    <td><input type="file" id="upload" name="upload" value="" /></td>
	    <td><button onclick="uploadFile()">上传</button></td>
	    <td><button onclick="OutputExce()">导出</button></td>
	</tr>
</table>
 
 
</body>
</html>