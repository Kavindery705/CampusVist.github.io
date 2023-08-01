<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="index.jsp"/>
<html>
<head>
<title>Campus visit</title>
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
	border-radius: 15px;
	cursor: pointer;
}

.form-group button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h2><%=session.getAttribute("name") %> Profile</h2>
		<form action="StudentProfile" method="post">
			
			<div class="form-group">
				<label>Enter id:  </label>
				<input type="text" name="id" value="<%=session.getAttribute("uid") %>" placeholder="Enter ID here " readonly >
			</div>
			
				<div class="form-group">
				<input type="submit" name="action" value="View"/>
			</div>
				<div class="form-group">
				<input type="submit" name="action" value="Delete"/>
			</div>
			<div class="form-group">
				<input type="submit" name="action" value="Edit"/>
			</div>
			
		</form>
		
		
	</div>
</body>
</html>