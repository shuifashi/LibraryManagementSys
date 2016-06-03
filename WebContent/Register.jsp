<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.struts2.ServletActionContext"
	%>
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
		<s:submit value="注册" name = 'test'></s:submit>
	</s:form>
	
	<s:form action="findBook">
		<s:textfield name="book.bookName" label="书名"></s:textfield>
		<s:submit value="查找" name = 'test'></s:submit>
	</s:form>
	<s:form action="addBook">
		<s:textfield name="book.bookName" label="书名"></s:textfield>
		<s:textfield name="book.ISBN" label="ISBN"></s:textfield>
		<s:textfield name="book.Author" label="ISBN"></s:textfield>
		<s:textfield name="book.Price" label="Price"></s:textfield>
		<s:textfield name="book.Publisher" label="Publisher"></s:textfield>
		<s:textfield name="book.bookAbstract" label="Astract"></s:textfield>
		<s:submit value="添加" name = 'test2'></s:submit>
	</s:form>
	<img src = <% out.print(getServletContext().getRealPath("upload")+"\\1.jpg"); %> width="200" height="150">
	<% out.print(getServletContext().getRealPath("upload")); %>
	<!-- enctype="multipart/form-data"不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。 -->
	<form action="file/upLoad" method="post" enctype="multipart/form-data">
		<input name="upload" type="file">
		<input name="btnUpload" type="submit" value="上传">
	</form>
	
	<body>  
	   <a href="file/download?fileName=input.txt">input.txt</a>  
	</body>  
	
</body>
</body>
</html>