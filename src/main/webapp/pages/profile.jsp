<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<style>

.btn 
{
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 18px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}

* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
    <a href="/homepage"><button  class="btn info button4" type="submit">Back to Home-Page</button></a>
	<br></br>
	<h2>User Profile - ${user.aname}</h2>
	<hr>
	<br></br>
<div class="row">
  <div class="column">
  <img src="https://w0.pngwave.com/png/867/694/user-profile-default-computer-icons-network-video-recorder-avatar-cartoon-maker-png-clip-art.png" width="500" height="444">
  </div>
  <div class="column">
  	<h2 style="color:Tomato;">User-ID       : ${user.aid}</h2><br>
	<h2 style="color:Tomato;">User-Name     : ${user.aname}</h2><br>
	<h2 style="color:Tomato;">User-Email    : ${user.email}</h2><br>
  </div>
</div>
</body>
</html>