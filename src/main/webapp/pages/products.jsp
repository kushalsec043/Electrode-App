<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif;}

.sidebar {
  height: 100%;
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: grey;
  overflow-x: hidden;
  padding-top: 16px;
}

.sidebar a {
  padding: 16px 8px 16px 16px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  display: block;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 250px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}

.btn 
{
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
  <a href="/addcontrol"><i class="fa fa-fw fa-wrench"></i>ADD a Product</a>
  <a href="/updatecontrol"><i class="fa fa-fw fa-wrench"></i>UPDATE a Product</a>
  <a href="/removecontrol"><i class="fa fa-fw fa-wrench"></i>REMOVE a Product</a>
   <a href="/logout"><i class="fa fa-fw fa-user"></i> Logout</a>
</div>

<div class="main">
<a href="/homepage"><button  class="btn info button4" type="submit">Back to Home-Page</button></a>
	<br>
	<hr>
  <h2>Customize Products On Home-Page</h2><hr>
  <h5><font color="red">${ProductMessage}</font></h5>
  <img src="https://cdn.shopify.com/s/files/1/0149/1691/1158/files/renegade-products-logo_fb8b852e-994d-4060-9ce9-5668cb42763a_410x.png?v=1556653108" alt="Trulli" width="1000" height="333">
  <ul>

<h3 style="font-family:verdana;font-size:25px">Options(Side Bar)</h3><hr>
<li style="font-family:verdana;font-size:25px;color:blue">Add a product to your shopping list</li>
<li style="font-family:verdana;font-size:25px;color:blue">Update a product in your shopping list</li>
<li style="font-family:verdana;font-size:25px;color:blue">Remove a product from your shopping list</li>
</ul>
</div>
     
</body>
</html> 
