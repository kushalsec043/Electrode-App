<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<style>
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
</style>

    <a href="/homepage"><button  class="btn info button4" type="submit">Back to Home-Page</button></a><br>
<hr>
<h2>Welcome to the Mart Help Center</h2><br>
<img src="https://img2.pngio.com/help-center-help-center-png-1680_600.png" alt="Trulli" width="500" height="166">

<h3>Frequently Asked Questions</h3><br>
<hr>
<ul>

<li>COVID-19 FAQs</li>
<li>What's new with the mart app?</li>
<li>Why is my order delayed?</li>
<li>What if there is a problem with my order?</li>
<li>How do I cancel an order?</li>
<li>How do I modify an order?</li>
<Li>Why was my order canceled?</Li>
<li>How do I track an order?</li>
<li>How do I return an item from mart.com?</li>
<li>How do I return an item from a Marketplace Seller?</li>
<li>How do I get a refund?</li>
<li>How do I get a return label?</li>
<li>How do I return a gift?</li>
<li>How do I reset my mart.com password?</li>
<li>When will I be charged?</li>
<li>Didn't find what you were looking for?
(
español
)</li>
</ul>  
<hr>
<h2>Logos Support</h2>
<hr>
<h4>Welcome to the Logos support center. Use the search bar to find help or browse topics by category.</h4>
<img src="https://www.officehelpcenter.com/wp-content/uploads/2015/09/Office-Help-Center-Logo-Black-Text1.png?quality=100.3015050520571" alt="Trulli" width="500" height="333">
</body>
</html>