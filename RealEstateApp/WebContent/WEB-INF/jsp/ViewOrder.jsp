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
<div class="view_order">
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title"><Strong>View Your Orders</Strong></h5><br/>
    <p class="card-text">
    <c:forEach items="${order.itemList}" var="item">
    <c:if test = "${item.quantity != 0}">
    <c:out value="${item.itemName}"></c:out><br/>
    <c:out value="${item.price}"></c:out><br/>
    <c:out value="${item.quantity}"></c:out><br/>
    </c:if>
	</c:forEach>
</p>
<br/>
	<form:form class="form-inline my-2 my-lg-0" modelAttribute="order" 
	action="/RealEstate/confirmorder" method="post">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Confirm Your Orders</button>
    </form:form>
  </div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>
</html>
