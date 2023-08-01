<%@page import="com.files.Entites.UserBean"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.files.Entites.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html");
PrintWriter pw =  response.getWriter();

UserDao db = new UserDao();
List<UserBean> list =db.getAllCourse();
%>
<h2><%=request.getParameter("course") %></h2>
<%-- <table width='100%' border='2px solid black'>
	<thead>
	<tr>
	<td>Id</td>
	<td>name</td>
	</tr>
	</thead>
	<tbody>
	<%
		for(UserBean ub:list)
		{
			
%>
			<tr>
	<td><%=ub.getC_id() %></td>
	<td><%=ub.getCourses() %></td>
	</tr>
			<%
			
		}
	%>
	
	</tbody>
	</table> --%>
</body>
</html>