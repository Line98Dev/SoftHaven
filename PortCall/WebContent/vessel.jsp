<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Vessels</title>
</head>
	<body>
        <div>
            <h2 id="listHeader">List of Ships</h2>
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>
        <table>
            <c:forEach var="vessel" items="${vessels}">
		        <tr>
                    <td>IMO:${vessel.IMO}</td>
                    <td>Name: ${vessel.IMO}</td>
                    <td>Flag: ${vessel.flag}</td>
                    <td>Name: ${vessel.name}</td>
                    <td>Built: ${vessel.built}</td>
                    <td>Call Sign: ${vessel.callSign}</td>
                    <td>Length: ${vessel.length}</td>
                    <td>Breadth: ${vessel.breadth}</td>
                    <td>Tonnage: ${vessel.tonnage}</td>
                    <td>MMSI: ${vessel.mmsi}</td>
                    <td>Type: ${vessel.type}</td>
                    <td>Owner Code: ${vessel.ownerCode}</td>
		        </tr>
            </c:forEach>
        </table>
        <p>${request}</p>
	</body>
</html>