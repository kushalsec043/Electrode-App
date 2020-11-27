<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to App!!!</title>
</head>

<style>
.center {
  margin: auto;
  width: 60%;
  border: 3px solid #73AD21;
  padding: 10px;
}
.btn {
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

</style>

<body>
<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<br></br>
 <form action="/homepage" method="get">
		<h3 class="center">Admin Access Page!</h3>
		<div class=center>
    <button  class="btn info button4" type="submit">Back to Home Page</button>
    </div>
 </form><br>
 
<form action="/admintoproduct" method="post">
<p class="center"><font color="red">${adminmessage}</font></p>
<br></br>
<div class="center">
   <h3>Enter UserName & PassWord!</h3>
 </div>
  <div class="center">
    <label for="adname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="adname" required><br>

	<br></br>
	
    <label for="adpass"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="adpass" required>
    
    <br></br>

    <button class="btn success button4" type="submit">Get_Access</button>
  </div>
   
 </form>

</body>

</html>