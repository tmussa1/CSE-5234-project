<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Information Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<div class="shipping_info">
<h2><Strong>Please Enter Your Shipping Address</Strong></h2>
<br/>
<br/>

<form:form modelAttribute="shippingInfo" method="post" action="/RealEstate/submitshipping">
  <div class="form-group col-md-6">
    <form:label path="customerName">Your Name</form:label>
    <form:input class="form-control" path="customerName" placeholder="your name"/>
  </div>
  <div class="form-group col-md-6">
    <form:label path="lineOne">Address Line One</form:label>
    <form:input class="form-control" path="lineOne" placeholder="Address Line One"/>
  </div>
  <div class="form-group col-md-6">
    <form:label path="lineTwo">Address Line Two</form:label>
    <form:input class="form-control" path="lineTwo" placeholder="Address Line Two"/>
  </div>
  <div class="form-group col-md-6">
    <form:label path="city">City</form:label>
    <form:input class="form-control" path="city" placeholder="City"/>
  </div>
  <div class="form-group col-md-6">
    <form:label path="state">State</form:label>
    <form:input class="form-control" path="state" placeholder="State"/>
  </div>
  <div class="form-group col-md-6">
    <form:label path="zipCode">Zip code</form:label>
    <form:input class="form-control" path="zipCode" placeholder="ZIp code"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>