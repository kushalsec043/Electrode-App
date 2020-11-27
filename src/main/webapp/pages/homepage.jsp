<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
body {font-family: "Lato", sans-serif;}

.sidebar {
  height: 100%;
  width: 190px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: grey;
  overflow-x: hidden;
  padding-top: 16px;
}

.sidebar a {
  padding: 6px 18px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  display: block;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 190px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}

img {
  border-radius: 12px;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

.btnview {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 90px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.btnadd {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 95px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}

.center {
  width: 45%;
  border: 3px solid #73AD21;
  padding: 10px;
}

.product-preview-container {
    border: 1px solid #ccc;
    padding: 5px;
    width: 280px;
    margin: 10px ;
    display: inline-block;
    text-align:center;
}

</style>
</head>
<body>
<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<div class="sidebar">
  <a href="/homepage"><i class="fa fa-fw fa-home" style="font-size:24px"></i> Home</a>
  <a href="/yourcart"><i class="fa fa-shopping-cart" style="font-size:24px"></i> Shp-Cart</a>
  <a href="/orderspage"><i class="fa fa-shopping-cart" style="font-size:24px"></i> My Orders</a>
  <a href="/admin"><i class="fa fa-fw fa-wrench"></i> Customize</a>
  <a href="/profile"><i class="fa fa-fw fa-user"></i> Profile</a>
  <a href="/about"><i class="fa fa-fw fa-envelope"></i> About Us</a>
   <a href="/help"><i class="fa fa-fw fa-envelope"></i> Help</a>
   <a href="/logout"><i class="fa fa-fw fa-user"></i> Logout</a>
</div>

<div class="main">
  <h2 style="color:#3498DB;">HomePage - Electrode Shopping Products </h2>
  <hr>
 
  <c:forEach items="${product}" var="element"> 
  <div class="product-preview-container">
    <h3 style="color:#D35400;">._${element.pname}_.</h3>
      <img id="rcorners3" src="${element.pimage}" width="260" height="200"><br></br>
      
       <li><a style="font-family:verdana;" href="/viewproduct?code=${element.pid}">View Product</a></li>
       <li><a style="font-family:verdana;" href="/addtocartrepo?code=${element.pid}">Add To Cart</a></li><br>
       </div>
</c:forEach>
  
</div>  
</script>   
</body>
</html> 
