<%@page import="java.util.List"%>
<%@page import="com.files.Entites.UserDao"%>
<%@page import="com.files.Entites.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%
UserDao db = new UserDao();
List<UserBean> list =  db.showAdmission1();

%>
 <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Student name</th>
            <th scope="col">Father Name</th>
            <th scope="col">D.O.B</th>
            <th scope="col">Gender</th>
            <th scope="col">Mobile no.</th>
            <th scope="col">Email</th>
             <th scope="col">Address</th>
            <th scope="col">City</th>
            <th scope="col">State</th>
            <th scope="col">Pin</th>
            <th scope="col">Tenth</th>
            <th scope="col">Twelfth</th>
            <th scope="col">Course</th>
             <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
        <%
		for(UserBean ub:list)
		{
			
			
%>
			<tr>
	<td><%=ub.getSname() %></td>
	<td><%=ub.getFathername() %></td>
	<td><%=ub.getDob() %></td>
	<td><%=ub.getGender() %></td>
	<td><%=ub.getPhone() %></td>
	<td><%=ub.getEmail() %></td>
	<td><%=ub.getAddress() %></td>
	<td><%=ub.getCity() %></td>
	<td><%=ub.getState() %></td>
	<td><%=ub.getPin() %></td>
	<td><a href="Download1?type=file1&id=<%=ub.getS_id()%>"><%=ub.getSname() %>Tenth</a></td>
	<td><a href="Download1?type=file2&id=<%=ub.getS_id()%>"><%=ub.getSname() %>Twelfth</a></td>
	<td><%=ub.getCourses() %></td>
	<td><a href="DeleteAdmission.jsp?id=<%=ub.getS_id() %>">Delete</a></td>
	</tr>
			<%
			
		}
	%>
        </tbody>
      </table>
      <h2><a href="adminProfile.jsp">Back</a></h2>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>