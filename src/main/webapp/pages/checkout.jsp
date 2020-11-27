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
  border: 3px solid orange;
  padding: 10px;
}
.btn {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 40px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.success {background-color: red;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: green;}

.button4 {border-radius: 12px;}

img {
  border-radius: 12px;
}


* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 80%;
  padding: 30px;
  height: 600px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
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
 </form><br>
<form action="/yourcart" method="get">
<button class="btn success button4" "type="submit">Go Back</button>
 </form>
 
 </div>
 
 <br></br>
 

<div class="row">
<div class="column">
<hr>
<form action="/addtocartrepo" method="post">
  <div class="center">

    <h3>Your product will be delivered in 2 hours...</h3>
    
  </div>
  <tr>
<h3 class="center">_PRODUCT REVIEW_</h3>
  <div class="center">
	<h5><font color="blue">Product Name  : ${cartname}</font></h5>
	<h5><font color="blue">Product Price : ${cartprice}</font></h5>
	<img id="rcorners3" src="${cartimage}" width="260" height="200"><br>
  </div>
      </tr>
  <br></br>
</form>
</div>
</div>

</body>

</html>