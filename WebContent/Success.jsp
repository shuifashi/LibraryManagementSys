<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.LMS.ssh.beans.Book"
	import="com.opensymphony.xwork2.ActionContext"
	import="java.util.List"
%>
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
	<h1><% if(session.getAttribute("userId")!= null) {out.print(session.getAttribute("userId"));} %></h1>
	<s:iterator value="bookList" status="st">
              <tr>                  
                    <td><s:property value="bookName" /></td>
                     <td><s:property value="bookId" /></td>                 
                 </tr> 
 	</s:iterator>
 	<a href= "/LibraryManagementSys/findBook?book.bookId=1">
 	<h2><% List<Object> book = (List<Object>)ActionContext.getContext().get("book1");  
 	if(book != null && book.size() != 0) {
 		for(Object o: book) {
 			Book temp = (Book)o;
 			out.print(temp.getAuthor());
 		}
 	}
 	%>
 	</h2>
</body>
</html>