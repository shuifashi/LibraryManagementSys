<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Search</title>
    <!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="./search.css" />


</head>

<body>
    


<div id="content" role="main">
    
    <div class="container">
        <div class="row">
           <div class="nav">
                <div class="logout col-md-1 col-md-offset-10">logout</div>
                <div class="userinfo col-md-1"><span class="glyphicon glyphicon-user" aria-hidden="true"><% if(session.getAttribute("userId")!= null) {out.print(session.getAttribute("userId"));} %></span></div>

           </div>
           <div class="logo col-md-4 col-md-offset-4 text-center">Logo </div>
           <div class="searchArea col-md-12">
                <form action="findBook">
                   <div class="searchInput input-group col-md-8 col-md-offset-2 form-group">
                       <input type="text" class="form-control" placeholder="please input" aria-describedby="basic-addon2" id="search">
                        <span class="input-group-addon"><input type="submit" class="btn btn-primary btn-block" id="submit-button" value="search"></button></span>

                   </div>
                    <div class="form-group search-options">
                        <label class="radio-inline col-md-2 col-md-offset-3">
                          <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked="true"> 书名
                        </label>
                        <label class="radio-inline col-md-2" >
                          <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 作者
                        </label>
                        <label class="radio-inline col-md-2">
                          <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> ISBN
                        </label>
                        
                    </div>
                    <div class="power-search col-md-2 col-md-offset-5">
                        <button class="btn btn-primary btn-block" id='power-search-button'>高级搜索</button>
                    </div>
               </form>
            </div>
        </div>
    </div>

</div> <!-- close #content -->


    <script src="../jquery.js"></script>
    <!-- <script src="//api.filepicker.io/v2/filepicker.js"></script> -->
    <script src="../bootstrap/js/bootstrap.js"></script>
    <script src="../common.js"></script>
    <script src="../app.js"></script>

</body>
</html>
