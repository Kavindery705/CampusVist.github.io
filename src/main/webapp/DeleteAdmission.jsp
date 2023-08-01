<%@page import="com.files.Entites.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
</head>
<body>
<%
int s_id = Integer.parseInt(request.getParameter("id"));
UserDao db = new UserDao();
int deleteForm = db.deleteAdmission1(s_id);
if(deleteForm==1)
{
	out.println("<script type=\"text/javascript\">");
	   out.println("alert('Form Record deleted!');");
	   out.println("location='AdmissionShow1.jsp';");
	   out.println("</script>");
}
else
{
	out.println("<script type=\"text/javascript\">");
	   out.println("alert('Form Record not deleted!!!!!!!!!!!');");
	   out.println("location='AdmissionShow1.jsp';");
	   out.println("</script>");
}

%>

</body>
</html>