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
                    	<td>IMO: ${ship.IMO}</td>
                    	<td>Berth: ${ship.berth}</td>
                    	<td>State: ${ship.state}</td>
		        	</tr>
        		</table>
        		<form class="form" method="post" action="${pageContext.request.contextPath}/shipAgentUpdated?imo=${ship.IMO}">
        			<h3>Update State:</h3>
        				<select id="newState" name="newState">
                    		<option value="expected">Expected</option>
                    		<option value="waiting">Waiting</option>
                    		<option value="at berth">At Berth</option>
                    		<option value="departed">Departed</option>
                    	</select>
                    	<a href="${pageContext.request.contextPath}/shipAgent">Cancel</a> or <button type="submit" name="submit">Update</button>
        		</form>
			</c:when>
			<c:otherwise>
				Ship not found
			</c:otherwise>
		</c:choose>
	</body>
</html>