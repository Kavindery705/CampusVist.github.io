<%@page import="com.files.Entites.UserDao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.files.Entites.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
UserBean ub = new UserBean();
UserDao db = new UserDao();
String myOtp=(String)session.getAttribute("otp1");

String otp=request.getParameter("text");
ub.setId((String)session.getAttribute("id"));
ub.setName((String)session.getAttribute("name"));
ub.setUsername((String)session.getAttribute("username"));
ub.setEmail((String)session.getAttribute("email"));
ub.setPassword((String)session.getAttribute("password"));

if(myOtp.equals(otp))
	
		{
	out.print("otp verified");
int status = db.inserUser(ub);
if(status==1)
{
	out.println("<script type=\"text/javascript\">");
	   out.println("alert('Record inserted');");
	   out.println("location='Studentlogin.jsp';");
	   out.println("</script>");
}
else
{
	out.print("not inserted");
}
		}
else
{
	   out.println("<script type=\"text/javascript\">");
	   out.println("alert('invalid otp');");
	   out.println("location='Register.jsp';");
	   out.println("</script>");
}
%>
</body> 
</html>