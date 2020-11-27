<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Shopping App!@!</title>
</head>

<style>
body, html {
  height: 100%;
  margin: 0;
}
.bg {
  /* The image used */
  background-image: url("https://thumbs.dreamstime.com/b/blue-background-football-russia-competition-pattern-cup-117984859.jpg");

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
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

h3 {text-align: center;}

.success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}
</style>
<div class="bg">
<body style="background-color:white;">
<br></br>
 <h3 class="center" style="color: white">ELECTRODE - Electronics Shopping App<br></br>_WELCOME PAGE_</h3>

 <br></br>
  <div class="center">
 <h3 style="color: white">Happiness is not in money, but in shopping.</h3>
 </div>
 <br></br>
 <div class="center">
 
  <h2 style="color: white">Login / Sign Up</h2>
 	<form action="/login" method="get"><br>
    <button class="btn success button4" type="submit">Login</button>
 	</form>
 <br></br>
 	<form action="/signup" method="get">
    <button class="btn info button4" type="submit">Sign Up</button>
  </form>
  <br></br>
</div>
</body>
</div>
</html>