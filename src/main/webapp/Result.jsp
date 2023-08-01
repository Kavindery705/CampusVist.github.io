<%@page import="com.files.Entites.UserDao"%>
<%@page import="com.files.Entites.UserBean"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
<style>
.form11{
width:400px;
margin:auto;
margin-top:4%;
line-height:2rem;
}
.btn1{
margin-top:4%;
}
</style>
</head>
<body>
<div class="form11">
<form action="showResult.jsp">
	Enter Registration no. : <div class="form-group">
	    <input type="text" class="form-control" name="reg_no" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Otp">
	
	  </div>
	 <button type="submit" name="action" class="btn btn-primary btn1">Submit</button>
	</form> 
	</div>
</body>
</html>