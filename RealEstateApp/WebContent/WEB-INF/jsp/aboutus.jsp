<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br/>
<%
	String img = "/resources/images/Tofik.jpg";
%>
<div class="image_row">
<div class="image_column">
	<img src="${pageContext.request.contextPath}/resources/images/Tofik.jpg" style="width:250px;height:250px;"/><br/>
	<span class="con_us">Tofik Mussa</span><br/>
	<span class="con_us">Co-Founder of Flintstone Real Estate</span><br/>
	<span class="con_us">5 years of customer service experience selling world class homes</span><br/>
</div>
<div class="image_column">
	<img src="${pageContext.request.contextPath}/resources/images/Xinyu.jpg" style="width:250px;height:250px;"/><br/>
	<span class="con_us">Xinyu Meng</span><br/>
	<span class="con_us">Co-Founder of Flintstone Real Estate</span><br/>
	<span class="con_us">Taking classes in OSU for 3 years.</span><br/>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>