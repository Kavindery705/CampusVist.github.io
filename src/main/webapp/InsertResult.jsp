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
<title>Insert title here</title>
<link rel="stylesheet" href="css/style1.css">
</head>

<body>
<%
response.setContentType("text/html");
PrintWriter pw =  response.getWriter();

UserDao db = new UserDao();
List<UserBean> list =db.getAllCourse();
%>
  <h1>Result</h1>
  <div class="con">
  <form action="InsertResult" method="get">
  Registration number : <input name="reg_no" type="text" />
    <br>
    <br>
    Student Name : <input name="sname" type="text" />
    <br>
    <br>
    Mother name: <input name="mothername" type="text" />
    <br>
    <br>
      
		 course :<select name="courses">
     <%
     for(UserBean ub:list)
     {
    	 
     %>
     <option><%=ub.getCourses() %></option>
     <%
     }
     
     %>
      </select> 
    <br><br>
    Subject1 marks : <input name="subject1marks" type="text" />
    <br>
    <br>
    Subject2 marks : <input name="subject2marks" type="text" />
    <br>
    <br>
    Subject2 marks : <input name="subject3marks" type="text" />
    <br>
    <br>
    Remarks : <select name="remarks">
      <option>Pass</option>
       <option>Fail</option>
      </select>
      <br><br>
      <input type="submit" name="action" value="InsertR" class="submit">
   </form>
 </div>
 <h2><a href="adminProfile.jsp">Back</a></h2>
</body>
</html>