<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sent Form</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ships.css"/>
</head>
<body>
	<p>Form was sent!</p>
	<a href="${pageContext.request.contextPath}/">Back</a>
	<form class="form" method="post" action="${pageContext.request.contextPath}/submitForm">
		<div>
			<label for="shipName">Ship Name:</label>
			<input type="text" name="shipName" id="shipName" disabled value="${shipName}" />
		</div>
		<div>
			<label for="callSign">Call Sign:</label>
			<input type="text" name="callSign" id="callSign" disabled value="${callSign}" />
		</div>
		<div>
			<label for="imo">IMO Number:</label>
			<input type="number" name="imo" id="imo" disabled value="${imo}" />
		</div>
		<div>
			<label for="agent">Agent Info:</label>
			<input type="text" name="agent" id="agent" disabled value="${agent}" />
		</div>
		<div>
			<label for="arrivingFrom">Arriving From:</label>
			<input type="text" name="arrivingFrom" id="arrivingFrom" disabled value="${arrivingFrom}" />
		</div>
		<div>
			<label for="eta">ETA:</label>
			<input type="date" name="eta" id="eta" disabled value="${eta}" />
		</div>
		<div>
			<label for="berth">Berth Number:</label>
			<input type="number" name="berth" id="berth" disabled value="${berth}" />
		</div>
		<div>
			<label for="nextPort">Next Port:</label>
			<input type="text" name="nextPort" id="nextPort" disabled value="${nextPort}" />
		</div>
		<div>
			<label for="etd">ETD:</label>
			<input type="date" name="etd" id="etd" disabled value="${etd}" />
		</div>
		<div>
			<label for="dischargeDescription">Discharging Cargo Description:</label>
			<input type="text" name="dischargeDescription" id="dischargeDescription" disabled value="${dischargeDescription}" />
		</div>
		<div>
			<label for="dischargeAmount">Discharging Cargo Amount:</label>
			<input type="number" name="dischargeAmount" id="dischargeAmount" disabled value="${dischargeAmount}" />
		</div>
		<div>
			<label for="loadingDescription">Loading Cargo Description:</label>
			<input type="text" name="loadingDescription" id="loadingDescription" disabled value="${loadingDescription}" />
		</div>
		<div>
			<label for="loadingAmount">Loading Cargo Amount:</label>
			<input type="number" name="loadingAmount" id="loadingAmount" disabled value="${loadingAmount}" />
		</div>
		<div>
			<label for="PassengerArrivalNumber">Number of Passengers on Arrival:</label>
			<input type="number" name="PassengerArrivalNumber" id="PassengerArrivalNumber" disabled value="${PassengerArrivalNumber}" />
		</div>
		<div>
			<label for="PassengerDepartureNumber">Number of Passengers on Departure:</label>
			<input type="number" name="PassengerDepartureNumber" id="PassengerDepartureNumber" disabled value="${PassengerDepartureNumber}" />
		</div>
	</form>
</body>
</html>