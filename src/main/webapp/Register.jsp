<jsp:include page="index.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
		<h2>Registration</h2>
		<form action="OtpVerify.jsp" method="get">

			<div class="form-group">
				<label for="id">Enter id :</label> <input type="id"
				name="id"	id="id" placeholder="Enter id" required>
			</div>
			<div class="form-group">
				<label for="sname">Enter Name:</label> <input type="text"
				name="name"	id="sname" placeholder="Enter a name" required>
			</div>
			<div class="form-group">
				<label for="username">Enter username:</label> <input type="text"
			name="username"		id="username" placeholder="Enter a username" required>
			</div>
			
			<div class="form-group">
				<label for="email">Enter email:</label> <input type="email" value="<%=request.getParameter("email") %>" id="email"
			name ="email"		placeholder="Enter your email" required>
			</div>
			<div class="form-group">
				<label for="password">Enter password:</label> <input type="password"
				name="password"	id="password" placeholder="Enter a password" required>
			</div>
			
			<div class="form-group">
				<button type="submit">Register</button>
			</div>
		</form>
	</div>
</body>
</html>