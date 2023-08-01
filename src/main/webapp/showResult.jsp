
<%@page import="com.files.Entites.UserBean"%>
<%@page import="com.files.Entites.UserDao"%>
<jsp:include page="index.jsp"/>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Campus Visit </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   
    <style>
    
        body{
            background-color: rgb(206, 252, 252);
        }
.container{

    margin-top: 70px;
    border: 2px solid black;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 500px;
    background-color: aliceblue;
    position: relative;
}
.right{
position:absolute;
right:0%;
top:0%;
}
.right a{
color:black;
}
.logo img{
    width: 150px;
    height: 150px;
}
.table{
    width: 300px;
}

    </style>
</head>
<body>
<%
long reg_no = Long.parseLong(request.getParameter("reg_no"));
UserDao db = new UserDao();
int total = db.totalMarks(reg_no);
UserBean ub = db.showResult(reg_no);
String sname = ub.getSname();
String mothername = ub.getMothername();
String course = ub.getCourses();
int sub1 = ub.getSubject1marks();
int sub2 = ub.getSubject2marks();
int sub3=ub.getSubject3marks();
String remark = ub.getRemarks();



%>
    <div class="container">
    <h5 class="right"><a href="Result.jsp">Check other</a></h5>
<div class="logo">
    <img src="img/universitylogo.jpg" alt="logo">
</div>

<div class="detail">
    <h5>Registration no.&nbsp;&nbsp;&nbsp;: <%=reg_no %></h5>
    <h5>Student name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=sname %></h5>
    <h5>Mother name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=mothername %></h5>
    <h5>Course &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=course %></h5>
</div>
    <table class="table">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Subject</th>
            <th scope="col">Marks</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">Subject 1</th>
            <td><%=sub1 %></td>
          </tr>
          <tr>
            <th scope="row">Subject 2</th>
            <td><%=sub2 %></td>
          </tr>
          <tr>
            <th scope="row">Subject 3</th>
            <td><%=sub3 %></td>
          </tr>
        </tbody>
      </table>
      <div class="left">

          <h6 >Total Marks : <%=total %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong >Max. Marks : 300</strong></h6>
          <h6 >Remarks &nbsp;&nbsp;  : <%=remark %></h6>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>