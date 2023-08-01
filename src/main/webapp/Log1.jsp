<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:include page="index.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Campus Visit</title>
    <style>
        .box{
            position: relative;
            display: flex;
            justify-content: space-evenly;
            align-items: center;

        }
        .box::before
        {
            content: "";
            background: url('img/campuslogin.jpg') no-repeat center center/cover;
            position: absolute;
            top: 0%;
            left: 0;
            width: 100%;
            height:500px;
            opacity: 0.5;
            /* background: transparent; */

            z-index: -1;
        }
        .box1
        {
           border: 2px solid black;
           width:300px;
           text-align: center;
           margin-top: 15%;
           background-color:  rgb(250, 238, 238);
           border-radius: 30px;

        }
        p{
            font-size: 1.6rem;
        }
        .box2
        {
            border: 2px solid black;
            width:300px;
            text-align: center;
            margin-top: 15%;
            background-color:  rgb(250, 238, 238);
           border-radius: 30px;

        }
    </style>
</head>
<body>
    <div class="box">
        <div class="box1">
            <h1>Admin Login</h1>
            <p><a href="Adminlogin.jsp">Click here to login</a></p>
        </div>
        <div class="box2">
            <h1>Student Login</h1>
            <p><a href="Studentlogin.jsp">Click here to login</a></p>
        </div>
    </div>
</body>
</html>