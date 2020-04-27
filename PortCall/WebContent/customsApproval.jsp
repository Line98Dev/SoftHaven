<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customs Agent</title>
</head>
	<body>
	<c:choose>
			<c:when test="${not empty form.IMO}">
        	<div>
            	<h2 id="listHeader">${form.name}</h2>
        	</div>
        	<table>
		        	<tr>
                    	<td>Name: ${form.name}</td>
			        	<td>Call Sign: ${form.callSign}</td>
	                    <td>IMO: ${form.IMO}</td>
	                    <td>Agent Info: ${form.agentInfo}</td>
	                    <td>Arriving From: ${form.arrivingFrom}</td>
	                    <td>ETA: ${form.ETA}</td>
	                    <td>Next Port: ${form.nextPort}</td>
	                    <td>ETD: ${form.ETD}</td>
	                    <td>Discharge Cargo Description: ${form.dischargeCargoDesc}</td>
	                    <td>Discharge Cargo Amount: ${form.dischargeCargoAmount}</td>
	                    <td>Loading Cargo Description: ${form.loadCargoDesc}</td>
	                    <td>Loading Cargo Amount: ${form.loadCargoAmount}</td>
	                    <td>Arriving Passengers: ${form.arrivalPassengers}</td>
	                    <td>Departing Passengers: ${form.departurePassengers}</td>
	                    <td>Validation: ${form.formValidation}</td>
		        	</tr>
        		</table>
        		<form class="form" method="post" href="${pageContext.request.contextPath}/shipAgentUpdated?imo=${form.IMO}">
        			<h3>Approval Status:</h3>
        				<a href="${pageContext.request.contextPath}/customsFormUpdated?imo=${form.IMO}&approve=false">Deny</a> or <a href="${pageContext.request.contextPath}/customsFormUpdated?imo=${form.IMO}&approve=true">Approve</a>
        		</form>
			</c:when>
			<c:otherwise>
				Pre-Approval Form not found
			</c:otherwise>
		</c:choose>
	</body>
</html>