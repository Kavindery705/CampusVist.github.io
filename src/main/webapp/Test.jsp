<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.files.Entites.UserDao"%>
<%@page import="com.files.Entites.UserBean"%>
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
<!-- <a href="Test1.jsp">view all</a> -->
 <form action="Test1.jsp">
<select name="course">
     <%
     for(UserBean ub:list)
     {
    	 
     %>
     <option><%=ub.getCourses() %></option>
     <%
     }
     
     %>
      </select> 
      <input type="submit" value="submit"/>
      </form> 
</body>
</html>