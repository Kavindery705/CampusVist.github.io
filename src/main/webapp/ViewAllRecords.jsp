<%@page import="com.files.Entites.UserDao"%>
<%@page import="com.files.Entites.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
   
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
PrintWriter pw =response.getWriter();
	UserDao ud = new UserDao();
int count = ud.countUser();
System.out.println(count);
int pagess = Integer.parseInt(request.getParameter("page"));
int total = 4;
int mod = count % total;
int pages= count / total ;
int npage = 0;
if(pagess==1)
{
	pagess--;
}
else
{
	pagess=(pagess-1)*total;
}
if(mod==0)
{
	npage= pages;
}
else
{
	npage = pages + 1;
}

if(npage != 0)
{
	for(int i =1 ;i<=npage;i++)
	{
		pw.print("<a href='ViewAllRecords.jsp?page="+i+"'>page"+i+"</a> |");
	}
}
List<UserBean> list =ud.getAllRecordPage(pagess , total);
%>
 <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">UserName</th>
            <th scope="col">Email</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
        <%
		for(UserBean ub:list)
		{
			
%>
			<tr>
	<td><%=ub.getId() %></td>
	<td><%=ub.getName() %></td>
	<td><%=ub.getUsername() %></td>
	<td><%=ub.getEmail() %></td>
	<td><a href="UpdateUser.jsp?id=<%=ub.getId() %>&name=<%=ub.getName() %>&username=<%=ub.getUsername()%>&email=<%=ub.getEmail() %>">Update</a></td>
	<td><a href="DeleteUser.jsp?id=<%=ub.getId() %>">Delete</a></td>
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