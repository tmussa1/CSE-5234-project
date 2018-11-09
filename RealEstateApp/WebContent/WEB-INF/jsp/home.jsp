<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flintstone Homepage</title>
</head>
<body class="image_container">
<jsp:include page="header.jsp"/>
<br/>
<div id="jumb_page" class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Welcome to Flintstone Homes</h1>
    <p class="lead">Most reliable vendors of Real Estate at a fare price</p>
  </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>