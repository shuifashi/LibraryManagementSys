<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>预约书籍</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/booking.css"> 
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script src="../js/booking.js"></script>
</head>
<body>
    <div class="container">
    	<h1>查询结果</h1>
    	<table class="table">
    		<!--表头-->
    		<tr>
			    <th>书名</th>
			    <th>作者</th>
			    <th>出版社</th>
			    <th>ISBN号</th>
			    <th>预约</th>
  			</tr>
  			<!--数据交互从这里开始-->
		    <tr>
		        <td>《天空的另一半》</td>
		        <td>尼可拉斯·D.克里斯多夫、 雪莉·邓恩</td>
		        <td>浙江人民出版社</td>
		        <td>9787213059384</td>
		        <td><form action="/aaa" method="post"><input value="userid" name="user-id" class="user-id"><button type="submit" name="idbutton" class="btn btn-primary" value="user-id">预约</button></form></td>
		    </tr>
		    <tr>
		        <td>《天空的绘本》</td>
		        <td>长田弘、 荒井良二</td>
		        <td>连环画出版社</td>
		        <td>9787505631311</td>
		        <td><form action="/aaa" method="post"><input value="userid" name="user-id" class="user-id"><button type="submit" name="idbutton" class="btn btn-primary" value="user-id">预约</button></form></td>
		    </tr>
		    <tr>
		        <td>《天空在脚下》</td>
		        <td>埃米莉•阿诺德•麦卡利、 孙晴峰</td>
		        <td>河北教育出版社</td>
		        <td>9787543470774</td>
		        <td><form action="/aaa" method="post"><input value="userid" name="user-id" class="user-id"><button type="submit" name="idbutton" class="btn btn-primary" value="user-id">预约</button></form></td>
		    </tr>
		    <tr>
		        <td>《东野圭吾：天空之蜂》</td>
		        <td>东野圭吾、 王维幸</td>
		        <td>南海出版公司</td>
		        <td>9787544275224</td>
		        <td><form action="/aaa" method="post"><input value="userid" name="user-id" class="user-id"><button type="submit" name="idbutton" class="btn btn-primary" value="user-id">预约</button></form></td>
		    </tr>
		    <!--数据交互到这里结束-->
    	</table>
    </div>
</body>
</html>