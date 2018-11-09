<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Entry Form</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<form:form modelAttribute="order" method="post" action="/RealEstate/submititem"> 
<table class="table table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Town House Name</th>
      <th scope="col">Apartment Price</th>
      <th scope="col">Number of Apartments</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${order.itemList}" var="item" varStatus="loop">
    <tr>
      <td><form:input path="itemList[${loop.index}].itemName" readonly="true" class="trow_1"/></td>
      <td><form:input path="itemList[${loop.index}].price" readonly="true" class="trow_2"/></td>
	  <td><form:input path="itemList[${loop.index}].quantity" /></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<input type="submit" value="Lease" class="btn_1">
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>