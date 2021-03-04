<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Card & User Info Page!!!</title>
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
</style>

<body>
<form action="/yourcart">
<div class="center">
<button class="btn info button4" "type="submit">Back to My-Cart</button>
</div>
</form>

<form action="/updatecardinfo" method="post">
  <div class="center">
  	<h3>Add User Information!!!</h3>
  	<hr>	
  	<br>
    <label for="aname"><b>User-name:</b></label>
    <input type="text" placeholder="Update Username" name="aname" value=${presentuser.aname} required>(required)<br>

	<br></br>
    
     <label for="email"><b>Mail-Id:</b></label>
    <input type="email" placeholder="Update Email" name="email" value=${presentuser.email} required>(required)<br>
    
    <br></br>
    
     <label for="address"><b>Address:</b></label>
    <input type="text" placeholder="Enter Address" name="address" value=${presentuser.address} required>(required)<br>
    
    <br></br>
    
     <label for="contact"><b>Contact No:</b></label>
    <input type="text" placeholder="Enter Contact Info" name="contact" value=${presentuser.contact} required>(required)<br>
    
    <br></br>
  </div>
  <div class="center">	
    <label for="cardname"><b>Enter Name on Card:</b></label>
    <input type="text" placeholder="Enter NameOnCard" name="cardname" required value=${usercard.nameon}>(required)<br>

	<br></br>
    
     <label for="cardno"><b>Enter Card no:</b></label>
    <input type="text" placeholder="Enter CardNo" name="cardno" required value=${usercard.card_no}>(required)<br>
    
    <br></br>
    
     <label for="expirn"><b>Enter Expiration:</b></label>
    <input type="text" placeholder="Enter Expiration MM/YY" name="expirn" required value=${usercard.expirn}>(required)<br>
    
    <br></br>
    
     <label for="cvv"><b>Enter CVV:</b></label>
    <input type="number" placeholder="Enter three digits"  name="cvv" required value=${usercard.cvv}>(required)<br>
    <br>
    <button class="btn success button4" type="submit">Place Order</button>
    <br></br>
    </div>
</form>
 
</body>

</html>