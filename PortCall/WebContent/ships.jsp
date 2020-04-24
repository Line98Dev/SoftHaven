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
	<form class="form" method="post" action="${pageContext.request.contextPath}/submitForm">
		<div>
			<label for="shipName">Ship Name:</label>
            <input type="text" name="shipName" id="shipName"/>
		</div>
		<div>
			<label for="callSign">Call Sign:</label>
            <input type="text" name="callSign" id="callSign" />
		</div>
		<div>
			<label for="imo">IMO Number:</label>
            <input type="number" name="imo" id="imo" />
		</div>
		<div>
			<label for="agent">Agent Info:</label>
            <input type="text" name="agent" id="agent">
		</div>
		<div>
			<label for="arrivingFrom">Arriving From:</label>
            <input type="text" name="arrivingFrom" id="arrivingFrom">
		</div>
		<div>
			<label for="eta">ETA FIGURE HOW YOU WANT TO DO THIS:</label>
            <input type="text" name="eta" id="eta">
		</div>
		<div>
			<label for="berth">Berth Number:</label>
            <input type="number" name="berth" id="berth">
		</div>
		<div>
			<label for="nextPort">Next Port:</label>
            <input type="text" name="nextPort" id="nextPort">
		</div>
		<div>
			<label for="etd">ETD FIGURE HOW YOU WANT TO DO THIS:</label>
            <input type="text" name="etd" id="etd">
		</div>
		<div>
			<label for="dischargeDescription">Dischaging Cargo Description:</label>
            <input type="text" name="dischargeDescription" id="dischargeDescription">
		</div>
		<div>
			<label for="dischargeAmount">Discharging Cargo Amount:</label>
            <input type="number" name="dischargeAmount" id="dischargeAmount">
		</div>
		<div>
			<label for="loadingDescription">Loading Cargo Description:</label>
            <input type="text" name="loadingDescription" id="loadingDescription">
		</div>
		<div>
			<label for="loadingAmount">Loading Cargo Amount:</label>
            <input type="number" name="loadingAmount" id="loadingAmount">
		</div>
		<div>
			<label for="PassengerArrivalNumber">Number of Passengers on Arrival:</label>
            <input type="number" name="PassengerArrivalNumber" id="PassengerArrivalNumber">
		</div>
		<div>
			<label for="PassengerDepartureNumber">Number of Passengers on Departure:</label>
            <input type="number" name="PassengerDepartureNumber" id="PassengerDepartureNumber">
		</div>
		<div>
			<label for="file">Crew Documents:</label>
            <input type="file" name="file" id="file">
		</div>
		<div>
			<button type="submit" name="submiter">Submit</button>
		</div>
	</form>
	<p>${request}</p>
</body>
</html>