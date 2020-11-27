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
 </form>
 </div>
 

<div class="row">
<div class="column">
<hr>
<form action="/homepage" method="get">
  <div class="center">

    <h3><font color="blue">.__Product Information__.</font></h3>
    
  </div>
  <tr>
<h3 class="center"><font color="black">Product: ${viewproduct.pname}</font></h3>
<h3 class="center"><font color="black">Price: ${viewproduct.pprice} $</font></h3>
  <div class="center">
	
	<img id="rcorners3" src="${viewproduct.pimage}" width="460" height="280"><br>
	
	<form action="/addtocartrepo" method="post">
<br>
  <div class="center">

    <li> Options :-)   <a style="font-family:verdana;" href="/addtocartrepo?code=${viewproduct.pid}">  Add To Cart</a></li><br>
    
  </div>
  <br>
</form>
  </div>
      </tr>
</form>
</div>


</body>

</html>
