<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ship Agent</title>
</head>
	<body>
	<c:choose>
			<c:when test="${not empty ship.IMO}">
        	<div>
            	<h2 id="listHeader">${ship.name}</h2>
        	</div>
        	<table>
		        	<tr>
                    	<td>IMO: <a href="${pageContext.request.contextPath}/shipAgentDetails?IMO=${ship.IMO}">${ship.IMO}</a></td>
                    	<td>Berth: ${ship.berth}</td>
                    	<td>State: ${ship.state}</td>
		        	</tr>
        		</table>
			</c:when>
			<c:otherwise>
				Ship not found
			</c:otherwise>
		</c:choose>
	</body>
</html>