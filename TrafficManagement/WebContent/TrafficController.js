var mymap = L.map('mapid').setView([55.665, 12.82], 10.50);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiZW13aXRvdXMiLCJhIjoiY2s4aHhzY2xkMDBhdDNtcGZ1a2U0MGxsdiJ9.VM3N5SL7m_tm418QvevcGg'
}).addTo(mymap);

//Setting custom icon
var myIcon = L.icon({
    iconUrl: 'circle.png',
    iconSize: [12, 12],
    popupAnchor: [0, 0]
});

//Function for Testing
function getJsonCollection() {
    let json = '[{"Class": "Class A", "ETA": {"$date": {"$numberLong": "1537412400000"}}, "ICES_Rect": 4488, "MMSI": 231261000, "PositionReport": {"CoG": 353.0, "Heading": 294, "NavigationalStatus": "Under way using engine", "Position": {"coordinates": [13.002288, 55.613685], "type": "Point"}, "RoT": 0.0, "SoG": 0.0}, "StaticData": {"A": 10, "B": 18, "Breadth": 10, "C": 5, "CallSign": "OZ2174", "D": 5, "DataSourceType": "AIS", "Destination": "SOUND AREA", "IMO": 9157997, "Length": 28, "Name": "VEN", "PositionFixingDevice": "GPS", "VesselType": "Tug"}, "Timestamp": {"$date": {"$numberLong": "1538351989000"}}}, {"Class": "Class A", "ICES_Rect": 4421, "MMSI": 306885000, "PositionReport": {"CoG": 171.5, "Heading": 175, "NavigationalStatus": "Under way using engine", "Position": {"coordinates": [12.70463, 55.805007], "type": "Point"}, "RoT": 0.0, "SoG": 9.6}, "StaticData": {"DataSourceType": "AIS", "PositionFixingDevice": "Undefined", "VesselType": "Undefined"}, "Timestamp": {"$date": {"$numberLong": "1538265600000"}}}, {"Class": "Class A", "ICES_Rect": 4421, "MMSI": 212503000, "PositionReport": {"CoG": 4.6, "Heading": 9, "NavigationalStatus": "Under way using engine", "Position": {"coordinates": [12.686973, 55.705525], "type": "Point"}, "RoT": 0.0, "SoG": 8.7}, "StaticData": {"DataSourceType": "AIS", "PositionFixingDevice": "Undefined", "VesselType": "Undefined"}, "Timestamp": {"$date": {"$numberLong": "1538265600000"}}}, {"Class": "Class A", "ETA": {"$date": {"$numberLong": "1538236800000"}}, "ICES_Rect": 4488, "MMSI": 354527000, "PositionReport": {"CoG": 18.4, "Heading": 351, "NavigationalStatus": "Moored", "Position": {"coordinates": [13.014508, 55.636252], "type": "Point"}, "RoT": 0.0, "SoG": 0.1}, "StaticData": {"A": 153, "B": 26, "Breadth": 28, "C": 18, "CallSign": "3EVP5", "D": 10, "DataSourceType": "AIS", "Destination": "MALMO", "IMO": 9655420, "Length": 179, "Name": "AFRICAN TEIST", "PositionFixingDevice": "GPS", "VesselType": "Cargo"}, "Timestamp": {"$date": {"$numberLong": "1538309285000"}}}, {"Class": "Class A", "ETA": {"$date": {"$numberLong": "1537719300000"}}, "ICES_Rect": 4421, "MMSI": 319030600, "PositionReport": {"CoG": 49.6, "Heading": 204, "NavigationalStatus": "Moored", "Position": {"coordinates": [12.595993, 55.683703], "type": "Point"}, "RoT": 0.0, "SoG": 0.0}, "StaticData": {"A": 28, "B": 8, "Breadth": 8, "C": 6, "CallSign": "ZCOV7", "D": 2, "DataSourceType": "AIS", "Destination": "COPENHAGEN", "IMO": 1008451, "Length": 36, "Name": "ARCADIA", "PositionFixingDevice": "Undefined", "VesselType": "Pleasure"}, "Timestamp": {"$date": {"$numberLong": "1538321819000"}}}]';

    return json;
}

//Functions for adding new ship to map
function getShipInfo(jsonData) {
    let info = "<p>MMSI: " + jsonData.MMSI + "</p>";
    info += "<p>IMO: " + jsonData.StaticData.IMO + "</p>";
    info += "<p>Name: " + jsonData.StaticData.Name + "</p>";
    info += "<p>Callsign: " + jsonData.StaticData.CallSign + "</p>";
    info += "<p>Coords: " + jsonData.PositionReport.Position.coordinates + "</p>";

    return info;
}

function getShipCoords(jsonData) {
    let coords = jsonData.PositionReport.Position.coordinates;

    return coords;
}

function addMarkerToMap(shipData, coords) {
    let marker = L.marker([coords[1], coords[0]], {icon: myIcon}).addTo(mymap);

    marker.bindPopup(shipData);
}

function AddingShipToView(json) {
    //Takes json and creates marker on map for a ship
    let jsonData = JSON.parse(json);

    for(x in jsonData) {
        let shipData = getShipInfo(jsonData[x]);
        let shipCoords = getShipCoords(jsonData[x]);
    
        addMarkerToMap(shipData, shipCoords);
    }
}

function clearMarkers() {
    //Removes old markers and makes new pane for new markers
    let oldPane = mymap.getPane("markerPane");

    oldPane.remove();
    mymap.createPane("markerPane");
}

//Calling of shit to test
AddingShipToView(getJsonCollection());

//document.body.addEventListener("click", clearMarkers);