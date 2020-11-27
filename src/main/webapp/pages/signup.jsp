<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp to App!!!</title>
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
<h3 class="center">Non-Member Registration!!!</h3>

<form action="/signedup" method="post">
<br></br>
  <div class="center">
	<p><font color="red">${signupmessage}</font></p>
	<br></br>
    <label for="aname"><b>Choose Username</b></label>
    <input type="text" placeholder="Enter Username" name="aname" required><br>

	<br></br>
	
    <label for="psw"><b>Choose Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required><br>
    
    <br></br>
    
     <label for="email"><b>Enter your Mail-Id</b></label>
    <input type="email" placeholder="Enter Email" name="email" required><br>
    
    <br></br>

    <button class="btn info button4" type="submit">Sign Up</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
  <br></br>
</form>

 <form action="/login" method="get">
 <h3 class="center">If you are a member of mart, then Login!!!</h3>
 <div class="center">
    <button class="btn success button4" type="submit">Back to Login!!!</button>
 </div>
 </form>
 
</body>

</html>