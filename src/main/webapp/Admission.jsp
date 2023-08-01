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
<link rel="stylesheet" href="css/style1.css">
</head>

<body>
<%
response.setContentType("text/html");
PrintWriter pw =  response.getWriter();

UserDao db = new UserDao();
List<UserBean> list =db.getAllCourse();
%>
  <h1>STUDENT ADMISSION FORM</h1>
  <div class="con">
  <form action="Admission" method="post"  enctype="multipart/form-data">
    Student Name : <input name="sname" type="text" />
    <br>
    <br>
    Father name: <input name="fathername" type="text" />
    <br>
    <br>
    D.O.B : <input name="dob" type="text" />
    <br>
    <br>
    Gender : <select name="gender">
      <option>Male</option>
       <option>Female</option>
      </select>

      Mobile No :<input name="phone" type="text" />
      <br><br>
      Email Address :<input name="email" type="text" size="62">
      <br><br>

      Address : <textarea name="address" cols="53" rows="5"></textarea>
      
      <br><br>

      City :<input name="city" type="text" />
      <br><br>
      State : <input name="state" type="text" />
      <br><br>
      pin : <input name="pin" type="text" />
      
       <br><br>
      tenth : <p>size should be less than 1024kb</p>

      Select Files : <input type="file" name="tenth" /><br><br>
      twelfth : <p>size should be less than 1024kb</p>
      Select Files : <input type="file" name="twelth" /><br><br>
      
		 course :<select name="course">
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
      <input type="submit" value="Submit" class="submit">
   </form>
 </div>
</body>
</html>
