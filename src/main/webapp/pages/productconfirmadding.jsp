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
  width: 50%;
  
  border: 3px solid black;
  padding: 10px;
}
.btn {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 40px; /* Add some padding */
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


* {
  box-sizing: border-box;
}

.form-group {
    float:left;
    margin-left: 25px;
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
<div class="form-group">
<form action="/homepage" method="get">
<button class="btn info button4" "type="submit">Back to Home-Page</button>
 </form>
 </div>
 <br></br>

<hr> 

<div class="row">
<div class="column">

  <div class="center">
    <h3><font color="blue">._Review Product Information -: Before Adding_.</font></h3>
  </div>
  
  <tr>
<h3 class="center"><font color="red">${productconfirm.pname}_ORIGINAL@_</font></h3>
  <div class="center">
	<h5><font color="blue">Product Name  : ${productconfirm.pname}</font></h5>
	<h5><font color="blue">Product Price : ${productconfirm.pprice}</font></h5>
	<img id="rcorners3" src="${productconfirm.pimage}" width="260" height="200"><br>
	   </tr>
  </div>
   <div class="center">
   <form action="/addtocartrepo" method="get">
    <button class="btn success button4" name="code" type="submit" value=${productconfirm.pid}>Add to cart</button>
	</form>
   </div>
</div>


</body>

</html>
