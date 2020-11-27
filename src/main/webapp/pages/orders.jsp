<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
.product-preview-container {
    border: 1px solid #ccc;
    padding: 5px;
    width: 300px;
    margin: 10px ;
    display: inline-block;
    text-align:center;
}

.form-group {
        display: inline-block;
        margin-left: 25px;
    }
    
    .buttons {
  width: 960px;
  margin: 0 auto;
}

.action_btn {
  display: inline-block;
  width: calc(50% - 4px);
  margin: 0 auto;
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
<button class="btn info button4" "type="submit">Back to Home Page</button>
</form><br>
<form action="/yourcart" method="get">
<button class="btn success button4" "type="submit">My Cart</button>
</form><br>
</div>
<hr>
<div>
  <h2>Your Orders - History of Items Purchased</h2>
  <hr>
  <h3><font color="red">${emptyorder}</font></h3>
  <c:forEach items="${orders}" var="element"> 
   <div class="product-preview-container">
   <h3 style="color:Tomato;">._${element.ordername}_.</h3>
      
      <img id="rcorners3" src="${element.orderimage}" width="260" height="200"><br>
      
      <li><a style="font-family:verdana;" href="/vieworder?code=${element.orderid}">View Details</a></li>
       <li><a style="font-family:verdana;" href="/cancelorder?code=${element.orderid}">Cancel Item</a></li><br>
      </div>
      
</c:forEach>
  
</div>  

</body>
</html>