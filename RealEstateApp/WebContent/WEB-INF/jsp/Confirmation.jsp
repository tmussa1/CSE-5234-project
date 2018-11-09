<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<div class="jumbotron"><Strong>Congratulations, your order is complete!</Strong></h1>
  <p class="lead">Your package will be shipped to <br/>
  	<c:out value="${shippingInfo.lineOne}"></c:out> ,
    <c:out value="${shippingInfo.lineTwo}"></c:out> ,
    <c:out value="${shippingInfo.city}"></c:out> ,
    <c:out value="${shippingInfo.state}"></c:out> ,
    <c:out value="${shippingInfo.zipCode}"></c:out>
  </p>
  <hr class="my-4">
  <p>The total charge is <%=request.getSession().getAttribute("total") %> </p>
  <p>Your confirmation number is  <%=request.getSession().getAttribute("confirmationNumber") %> </p>
  <a class="btn btn-primary btn-lg" href="/RealEstate/" role="button">Go back to homepage</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>