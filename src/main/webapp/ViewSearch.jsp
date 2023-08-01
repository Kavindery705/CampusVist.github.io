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
<h1>User records</h1>
<h2>Id         : <%=request.getAttribute("id") %></h2>
<h2>Name       : <%=request.getAttribute("name") %></h2>
<h2>Username   : <%=request.getAttribute("username") %></h2>
<h2>User Email : <%=request.getAttribute("email") %></h2>

</body>
</html>