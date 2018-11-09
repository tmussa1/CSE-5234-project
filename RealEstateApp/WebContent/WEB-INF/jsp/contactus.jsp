<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<div class="card contact" style="width: 18rem;">
  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/contact.jpg"/>
  <div class="card-body">
    <h5 class="card-title">For further inquiries</h5>
    <p class="card-text">Email: meng.342@buckeyemail.osu.edu</p>
    <p class="card-text">Phone Number: 202-840-4694</p>
    <p class="card-text">Address: 2015 Neil Avenue</p>
    <p class="card-text"> Columbus, OH, 43210</p>
    <a href="#" class="btn btn-primary">Make Enquiries</a>
  </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>