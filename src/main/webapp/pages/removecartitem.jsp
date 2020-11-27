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

img {
  border-radius: 12px;
}
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
<form action="/yourcart" method="get">
		<h3 class="center">Cart Update!!!</h3>
		<div class="center">
    <button  class="btn info button4" type="submit">Back to My Cart</button>
 </div>
 </form><br>

<form action="/removecartrepo" method="post">
<br></br>
  <div class="center">
	<h5><font color="blue">${cartIdmessage}</font></h5>
	<h4 style="color:Tomato;">Product Name    : ${shname}</h4>
	<img id="rcorners3" src="${shimage}" width="260" height="200"><br>
  </div>
  <br></br>
</form>
</body>

</html>