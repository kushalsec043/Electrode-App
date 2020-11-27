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
  width: 50%;
  padding: 30px;
  height: 600px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
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
<form action="/homepage" method="get">
<button class="btn info button4" "type="submit">Back to Home Page</button>
<button class="btn success button4" "type="submit">View Product-ID</button>
 </form><br>
 
<hr>
<div class="center">
		<h3>ENTER ID TO ADD PRODUCT TO CART!!!</h3>
</div>
<form action="/addtocartrepo" method="post">
<br></br>
  <div class="center">
	<h5><font color="red">${wrongid}</font></h5>
    <label for="pid"><b>Enter Product-ID</b></label>
    <input type="number" placeholder="Enter UserId" name="pid" required><br>

	<br></br>

    <button class="btn success button4" type="submit">_ADD_</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
  <br></br>
</form>

</body>

</html>