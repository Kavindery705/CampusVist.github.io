<%@page import="java.util.List"%>
<%@page import="com.files.Entites.UserBean"%>
<%@page import="com.files.Entites.UserDao"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%
response.setContentType("text/html");
PrintWriter pw =  response.getWriter();

UserDao db = new UserDao();
List<UserBean> list =db.getAllCourse();
%>
  <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Sr no.</th>
            <th scope="col">course</th>
            <th scope="col">details</th>
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
	<td><a href="Download?type=<%= ub.getCourses()%>"><%=ub.getCourses() %> details</a></td>
	</tr>
			<%
			
		}
	%>
        </tbody>
      </table>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>