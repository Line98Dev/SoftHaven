<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ship Agent</title>
</head>
	<body>
        <div>
            <h2 id="listHeader">List of Ships</h2>
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>
        <table>
            <c:forEach var="ship" items="${ships}">
		        <tr>
                    <td>IMO: <a href="${pageContext.request.contextPath}/shipAgentDetails?imo=${ship.IMO}">${ship.IMO}</a></td>
                    <td>Name: ${ship.name}</td>
                    <td>Berth: ${ship.berth}</td>
                    <td>State: ${ship.state}</td>
		        </tr>
            </c:forEach>
        </table>
        <p>${request}</p>
	</body>
</html>