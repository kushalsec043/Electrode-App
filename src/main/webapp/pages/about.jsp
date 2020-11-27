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
<h2>About Us</h2><br>
<hr>
<h3>
What started small, with a single discount store and the simple idea of selling more for less,
has grown over the last 50 years into the largest retailer in the world. Each week, nearly 265
million customers and members visit approximately 11,500 stores under 56 banners in 27 countries 
and eCommerce websites. With fiscal year 2020 revenue of $524 billion, Walmart employs over 2.2 
million associates worldwide. Walmart continues to be a leader in sustainability, corporate philanthropy 
and employment opportunity. It’s all part of our unwavering commitment to creating opportunities and bringing 
value to customers and communities around the world.
</h3>
<h2>MART SHOPPINGCART.COM</h2>
<img src="https://i.ytimg.com/vi/GEAW8kmulvM/maxresdefault.jpg" alt="Trulli" width="500" height="333">
<img src="https://www.smejapan.com/wp-content/uploads/2018/10/5976773233_fc072f44d9_z.jpg" alt="Trulli" width="500" height="333">
<img src="https://content.fortune.com/wp-content/uploads/2019/05/gettyimages-492772256-e1557855934120.jpg" alt="Trulli" width="500" height="333">
<img src="https://c8.alamy.com/comp/C67HEY/familymart-convenience-store-in-tokyo-japan-C67HEY.jpg" width="500" height="333">

<footer>
<h5>
Mart Inc. ( /ˈwɔːlmɑːrt/; formerly Mart Stores, Inc.) is an American multinational retail corporation that operates a chain of hypermarkets, discount department stores, and grocery stores, headquartered in Bentonville, Arkansas.[9] The company was founded by Sam Walton in 1962 and incorporated on October 31, 1969. It also owns and operates Sam's Club retail warehouses.[10][11] As of April 30, 2020, Mart has 11,484 stores and clubs in 27 countries, operating under 56 different names.[1][2][12] The company operates under the name Mart in the United States and Canada, as mart de México y Centroamérica in Mexico and Central America, as Asda in the United Kingdom, as the Seiyu Group in Japan, and as Best Price in India. It has wholly owned operations in Argentina, Chile, Canada, and South Africa. Since August 2018, mart only holds a minority stake in mart Brasil, which was renamed Grupo Big in August 2019, with 20 percent of the company's shares, and private equity firm Advent International holding 80 percent ownership of the company.

Mart is the world's largest company by revenue, with US$514.405 billion, according to the Fortune Global 500 list in 2019. It is also the largest private employer in the world with 2.2 million employees. It is a publicly traded family-owned business, as the company is controlled by the Walton family. Sam Walton's heirs own over 50 percent of Walmart through their holding company Walton Enterprises and through their individual holdings.[13] Walmart was the largest United States grocery retailer in 2019, and 65 percent of Mart's US$510.329 billion sales came from U.S. operations.[3][14]

Mart was listed on the New York Stock Exchange in 1972. By 1988, it was the most profitable retailer in the U.S.,[15] and it had become the largest in terms of revenue by October 1989.[16] The company originally was geographically limited to the South and lower Midwest, but it had stores from coast to coast by the early 1990s. Sam's Club opened in New Jersey in November 1989, and the first California outlet opened in Lancaster, California, in July 1990. A Walmart in York, Pennsylvania opened in October 1990, the first main store in the Northeast.[17]

Mart's investments outside the U.S. have seen mixed results. Its operations and subsidiaries in Canada, the United Kingdom, Central America, South America and China are highly successful, whereas its ventures failed in Germany and South Korea.

<br></br>
Copyright 2020 © Bigtree Entertainment Pvt. Ltd. All Rights Reserved.
The content and images used on this site are copyright protected and copyrights vests with the respective owners. The usage of the content and images on this website is intended to promote the works and no endorsement of the artist shall be implied. Unauthorized use is prohibited and punishable by law.
</h5>
</footer>
</body>
</html>