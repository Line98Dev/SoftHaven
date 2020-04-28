<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customs Queue</title>
</head>
	<body>
        <div>
            <h2 id="listHeader">List of Ships</h2>
            <a href="${pageContext.request.contextPath}/vessel">List of Vessel</a>
            <a href="${pageContext.request.contextPath}/">Back to Home</a>
        </div>
        <table>
            <c:forEach var="form" items="${forms}">
		        <tr>
		        	<td>Name: ${form.name}</td>
		        	<td>Call Sign: ${form.callSign}</td>
                    <td>IMO: <a href="${pageContext.request.contextPath}/customsDetails?imo=${form.IMO}">${form.IMO}</a></td>
                    <td>Validation: ${form.formValidation}</td>
		        </tr>
            </c:forEach>
        </table>
        <p>${request}</p>
	</body>
</html>