<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pre-Arrival Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ships.css"/>

</head>
<body>
	<form class="form" method="post" action="${pageContext.request.contextPath}/submitForm">
		<div>
			<label for="shipName">Ship Name:</label>
            <input type="text" name="shipName" id="shipName" required />
		</div>
		<div>
			<label for="callSign">Call Sign:</label>
            <input type="text" name="callSign" id="callSign" required />
		</div>
		<div>
			<label for="imo">IMO Number:</label>
            <input type="number" name="imo" id="imo" required />
		</div>
		<div>
			<label for="agent">Agent Info:</label>
            <input type="text" name="agent" id="agent" required />
		</div>
		<div>
			<label for="arrivingFrom">Arriving From:</label>
            <input type="text" name="arrivingFrom" id="arrivingFrom"required />
		</div>
		<div>
			<label for="eta">ETA:</label>
            <input type="date" name="eta" id="eta" required />
		</div>
		<div>
			<label for="berth">Berth Number:</label>
            <input type="number" name="berth" id="berth" required />
		</div>
		<div>
			<label for="nextPort">Next Port:</label>
            <input type="text" name="nextPort" id="nextPort" required />
		</div>
		<div>
			<label for="etd">ETD:</label>
            <input type="date" name="etd" id="etd" required />
		</div>
		<div>
			<label for="dischargeDescription">Discharging Cargo Description:</label>
            <input type="text" name="dischargeDescription" id="dischargeDescription" required />
		</div>
		<div>
			<label for="dischargeAmount">Discharging Cargo Amount:</label>
            <input type="number" name="dischargeAmount" id="dischargeAmount" required />
		</div>
		<div>
			<label for="loadingDescription">Loading Cargo Description:</label>
            <input type="text" name="loadingDescription" id="loadingDescription" required />
		</div>
		<div>
			<label for="loadingAmount">Loading Cargo Amount:</label>
            <input type="number" name="loadingAmount" id="loadingAmount" required />
		</div>
		<div>
			<label for="PassengerArrivalNumber">Number of Passengers on Arrival:</label>
            <input type="number" name="PassengerArrivalNumber" id="PassengerArrivalNumber" required />
		</div>
		<div>
			<label for="PassengerDepartureNumber">Number of Passengers on Departure:</label>
            <input type="number" name="PassengerDepartureNumber" id="PassengerDepartureNumber" required />
		</div>
		<div>
			<label for="file">Crew Documents:</label>
            <input type="file" name="file" id="file" required />
		</div>
		<div>
			<button type="submit" name="submit">Submit</button>
		</div>
	</form>
</body>
</html>