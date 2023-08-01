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
      text-align: center;
    }
    h1 {
      color: #333;
    }
    h2 {
      color: #666;
    }
  </style>
<script>
    var countdownDuration = 1;
    
    function startCountdown() {
      var countdownElement = document.getElementById("countdown");
      var count = countdownDuration * 60;
      var timer = setInterval(function() {
        var minutes = Math.floor(count / 60);
        var seconds = count % 60;
        
        countdownElement.textContent = minutes + "m " + seconds + "s";
        
        if (count <= 0) {
          clearInterval(timer);
          document.querySelector("h2").innerHTML = "Countdown finished!";
          top.document.location.replace('Studentlogin.jsp');
      
        } else {
          count--;
        }
      }, 1000);
    }
    
    window.onload = startCountdown;
  </script>
</head>
<body>
<h1>You have Reached Maximum Attempts!</h1>
  <h2>Please wait for <span id="countdown"></span> to try again!</h2>
</body>
</html>