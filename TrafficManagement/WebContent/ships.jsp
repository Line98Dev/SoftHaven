<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random Ships</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ships.css"/>

</head>
<body>
<a href="${pageContext.request.contextPath}/trafficMonitor">Traffic Monitor</a>
<table class="listing">
	<tr>
		<th>IMO</th>
		<th>Name</th>
		<th>Tonnage</th>
		<th>Flag</th>
	</tr>
	<c:forEach var="ship" items="${ships}">
		<tr>
			<td>${ship.imo}</td>
			<td>${ship.name}</td>
			<td>${ship.tonnage}</td>
			<td>${ship.flag}</td>
		</tr>
	</c:forEach>
</table>
<p>${request}</p>
</body>
</html>