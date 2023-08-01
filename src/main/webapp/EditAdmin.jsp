<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Campus Visit</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #4C4C6D;
	margin: 0;
	padding: 0;
}

.container {
	width: 400px;
	margin: 0 auto;
	margin-top: 100px;
	background-color: #FFFAF4;
	border: 2px solid #4C4C6D;
	padding: 40px;
	border-radius: 15px;
}

h2 {
	text-align: center;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
}

.form-group input {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid #4C4C6D;
}

.form-group button {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.form-group button:hover {
	background-color: #45a049;
}
</style>
</head>

<body>
<div class="container">
		<form action="AdminProfile" method="post">

			<div class="form-group">
				<label for="id">Enter id :</label> <input type="id"
				name="id" value="<%=request.getParameter("id") %>" id="id" placeholder="Enter id" readonly>
			</div>
			<div class="form-group">
				<label for="sname">Enter Name:</label> <input type="text"
				name="name" value="<%=request.getAttribute("name") %>"	id="name" placeholder="Enter a name" required>
			</div>
			<div class="form-group">
				<label for="username">Enter username:</label> <input type="text"
			name="username"		id="username" value="<%=request.getAttribute("username") %>"	placeholder="Enter a username" required>
			</div>
			
			<div class="form-group">
				<label for="email">Enter email:</label> <input type="email" id="email"
			name ="email"value="<%=request.getAttribute("email") %>"			placeholder="Enter your email" required>
			</div>
			<div class="form-group">
				<label for="password">Enter new password:</label> <input type="password"
				name="password"	id="password" value="<%=request.getAttribute("password") %>"	 placeholder="Enter a password" required>
			</div>
			
			<div class="form-group">
				<input type="submit" name="action" value="Update">
			</div>
		</form>
</body>
</html>