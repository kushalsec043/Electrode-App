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

<br></br>
 <form action="/welcome" method="get">
		<h3 class="center">Welcome to Login Page!</h3>
		<div class="center">
    <button  class="btn info button4" type="submit">Back to Welcome Page</button>
 </div>
 </form><br>
 
<form action="/homepage" method="post">

<p class="center"><font color="red">${errorMessage}</font></p>
<br></br>
<div class="center">
   <h3>Enter Details to Login!</h3>
 </div>
  <div class="center">
    <label for="aname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="aname" required><br>

	<br></br>
	
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
    
    <br></br>

    <button class="btn success button4" type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
  </form>
  <br></br>

   <form action="/signup" method="get">
		<h3 class="center">Non-Member? <br>Sign Up to Login!</h3>
		<div class="center">
    <button  class="btn info button4" type="submit">Sign-Up</button>
 </div>
 </form>
   
 

</body>

</html>