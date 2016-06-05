<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.LMS.ssh.beans.Book"
	import="com.opensymphony.xwork2.ActionContext"
	import="java.util.List"
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="zh-CN">
<head>
	<title>预约书籍</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../booking/css/booking.css"> 
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script src="../booking/js/booking.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="nav">
         <div class="logout col-md-1 col-md-offset-10"><a href="/LibraryManagementSys/WebPage/logout/logout.jsp">logout</a></div>
         <div class="userinfo col-md-1"><span class="glyphicon glyphicon-user" aria-hidden="true"><% if(session.getAttribute("userId")!= null) {out.print(session.getAttribute("userId"));} %></span></div>

    </div>
    <div class="container">
    	<h1>查询结果</h1>

    	<table class="table table-striped table-hover">
    		<!--表头-->
    		<tr>
			    <th>书名</th>
			    <th>作者</th>
			    <th>出版社</th>
			    <th>ISBN号</th>
			    <th>位置</th>
			    <th>状态</th>
			    <th>详情</th>
			    <th>预约</th>
  			</tr>
  			<!--数据交互从这里开始-->
  			<%
  			List<Object> book = (List<Object>)ActionContext.getContext().getSession().get("book1");
  		 	if(book != null && book.size() != 0) {
  		 		for(int i = 0; i < book.size(); i++) {
  		 			Book temp = (Book)book.get(i);
  		 			out.println("<tr>");
  		 			out.println("<td>"+temp.getBookName()+"</td>");
  		 			out.println("<td>"+temp.getAuthor()+"</td>");
  		 			out.println("<td>"+temp.getPublisher()+"</td>");
  		 			out.println("<td>"+temp.getISBN()+"</td>");
  		 			out.println("<td>"+temp.getLocation()+"</td>");
  		 			if(temp.getFlag() == 1) {
  		 				out.println("<td>书籍尚未借出</td>");
  		 			} else if(temp.getFlag() == 2) {
  		 				out.println("<td>可以预约</td>");
  		 			} else {
  		 				out.println("<td>书籍已经被预约</td>");
  		 			}
  		 			out.println("<td><form method='post' accept-charset='utf-8' action='bookInfo' novalidate>");
  		 			out.println("<input type='bookId' name='book.bookId' id='bookId' value='"+temp.getBookId()+"' style='display:none' />");
  		 			out.println("<input type='submit' name='bookbutton' class='btn btn-primary' value='查看详情'  />");
  		 			out.println("</form></td>");
  		 			out.println("<td><form method='post' accept-charset='utf-8' action='reserveBook' novalidate>");
  		 			String userid = "";
  		 			if(session.getAttribute("userId") != null)
  		 				userid = (String)session.getAttribute("userId");
  		 			out.println("<input type='userId' name='record.userId' id='userId' value='"+userid+"' style='display:none' />");
  		 			out.println("<input type='bookId' name='record.bookId' id='bookId' value='"+temp.getBookId()+"' style='display:none' />");
  		 			if(temp.getFlag()!=2) {
  		 				out.println("<input type='submit' name='idbutton' class='btn btn-primary' value='预约' disabled='disabled' />");
  		 			} else {
  		 				out.println("<input type='submit' name='idbutton' class='btn btn-primary' value='预约' onclick='this.disabled=true'/>");
  		 			}
  		 			out.println("</form></td>");
  		 			out.println("</tr>");
  		 		}
  		 	}
  			%>
		    <!--数据交互到这里结束-->

    	</table>
		<!-- 模态框控制（Modal） -->
		<div class="successFlag" id="unsuccess" style="display:none">${status}</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		         </div>
		         <div class="modal-body">
		         	<!-- 预约成功/失败信息及代码 -->
		            <h2 id="outputWords"></h2>
		            <h4><%= ActionContext.getContext().get("status") %></h4> 
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
		         </div>
		      </div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
    </div>
</body>
</html>