<%@page import="com.files.Entites.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
</head>
<body>
<%
String id = request.getParameter("id");
UserDao db = new UserDao();
if(!(id.equals("a101"))){
	int status = db.deleteUser(id);
	if(status==1)
	{
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('Record deleted!');");
		   out.println("location='adminProfile.jsp';");
		   out.println("</script>");
	}
	else
	{
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('Record not deleted!!!!!!!!!!!');");
		   out.println("location='adminProfile.jsp';");
		   out.println("</script>");
	}
}
else
{
	out.println("<script type=\"text/javascript\">");
	   out.println("alert('Record not deleted!!!!!!!!!!!');");
	   out.println("location='adminProfile.jsp';");
	   out.println("</script>");
}

%>
</body>
</html>