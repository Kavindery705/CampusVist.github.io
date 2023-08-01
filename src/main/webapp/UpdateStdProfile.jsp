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
<body>
<jsp:useBean id="user" class="com.files.Entites.UserBean"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
UserDao db = new UserDao();
int status = db.updateUser(user);
if(status==1)
{
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('Record updated!');");
		   out.println("location='ViewAllRecords.jsp?page=1';");
		   out.println("</script>");
}
else
{
	out.println("<script type=\"text/javascript\">");
out.println("alert('Record not updated!');");
out.println("location='ViewAllRecords.jsp?page=1';");
out.println("</script>");
}
%>
</body>
</html>