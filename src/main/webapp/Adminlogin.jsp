<%@page import="com.files.Entites.UserDao"%>
<%@page import="com.files.Entites.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
</head>
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
<body>
<%
String n = request.getParameter("attempt");
int i;
this.log("n :"+n);
if(n==null)
{
	i=1;
}
else
{
	i =Integer.parseInt(n);
	if(i==3)
	{
		%>
		<jsp:forward page="MaxAttemptError1.jsp"></jsp:forward>
		<%
	}
	else
	{
		i++;
	}
}
%>
<form action="LoginServlet" method="post"class="form11"> 
<input type="hidden" name="attempt" value="<%=i%>">
  <div class="form-group">
    <label for="exampleInputEmail1">Username </label>
    <input type="text" class="form-control" name="ausername" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username">

  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="apassword" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary btn1">Submit</button>
</form>

</body>
</html>