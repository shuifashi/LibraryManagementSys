<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Successful Page</title>
</head>
<body>
	<h1>Congratulations! Successful!</h1>
	<h1><s:textfield name="#name" /></h1>
	<h1><%= session.getAttribute("name") %></h1>
</body>
</html>