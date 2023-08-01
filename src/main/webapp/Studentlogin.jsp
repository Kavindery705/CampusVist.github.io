<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Drive</title>
<style>
.form11{
width:400px;
margin:auto;
margin-top:4%;
line-height:2rem;
position:relative;
}
.btn1{
margin-top:4%;
}
.btn2{
position:absolute;
top:81%;
left:25%;

}
</style>
</head>
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
		<jsp:forward page="MaxAttemptError.jsp"></jsp:forward>
		<%
	}
	else
	{
		i++;
	}
}
%>
<body>
	<div class="form11">
	<form action="StudentLoginServlet" method="post"> 
	<input type="hidden" name="attempt" value="<%=i%>">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Username </label>
	    <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username">
	
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
	  </div>
	  <button type="submit" name="action" class="btn btn-primary btn1">Submit</button>
	</form>
	  <button type="submit" class="btn btn-primary btn2"><a href="Register.jsp" style="color:white; text-decoration:none;">Sign up</a></button>
	</div>
</body>
</html>