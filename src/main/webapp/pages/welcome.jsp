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
  background-image: url("http://adwallpapers.xyz/uploads/posts/1930-dark-blue-grunge-background.jpg");

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

.product-preview-container {
    border: 1px solid #ccc;
    padding: 5px;
    width: 280px;
    margin: 10px ;
    display: inline-block;
    text-align:center;
}


h3 {
text-align: center;
font-size: 30px;
}

.success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}
</style>

<div class="bg">
<body style="background-color:white;">
<br></br>
<br></br>

 <h3 class="center" style="color: white">ShopDrop - Shopping Web App<br></br>_WELCOME PAGE_</h3>
 <br></br>
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