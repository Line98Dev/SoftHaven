<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Traffic Control Menu</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ships.css"/>

</head>
<body>
<h1>Welcome to the Traffic Control Menu</h1>
<a href="${pageContext.request.contextPath}/trafficMonitor">Click here to open the Traffic Viewer</a>
<p>${request}</p>
</body>
</html>