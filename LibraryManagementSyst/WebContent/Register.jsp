<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register Page</title>
</head>
<body>

	<s:form action="register">
		<s:textfield name="user.username" label="用户名"></s:textfield>
		<s:password name="user.password" label="密码"></s:password>
		<s:textfield name="user.email" label="邮箱"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>
	<body>

	<!-- enctype="multipart/form-data"不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。 -->
	<form action="file/upLoad" method="post" enctype="multipart/form-data">
		<input name="upload" type="file">
		<input name="btnUpload" type="submit" value="上传">
	</form>
	
</body>
</body>
</html>