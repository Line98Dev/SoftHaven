# SoftHaven
See branches for the different sections of the application: EvansFunPortCallAdventure is Port Call module, and the EvansFunTrafficAdventure is the Traffic Controller module.

## Group Members
* Evan Witous
* Hunter Line
* Corbin Creedon
* Matthew Nessel


## Tech Stack
* Java
* HTML
* JS
* MySQL
* Eclipse IDE
* Glassfish

## Current Features:
### Traffic Controller
* Displays Map of the Port of Copenhagen-Malmö
* Capability to display proper ship locations
### Ship Agent
* View information on a specific ship
* List all ships
* Edit status of ships
### Customs Officer
* View unapproved Pre-Arrival Forms
* List all vessels
* Approve and unapprove Pre-Arrival Forms
### Ship Master
* Submit Pre-Arrival Form

## Architecture
The architecture is very similar to the diagram provided by Nicholas Renet for the inital view of the project. We changed very little from the base architecture. 
![alt text](https://github.com/htline/SoftHaven/blob/master/images/architecture.png "Architecture")

## DB Resources
[This is the link to the Portcall DB](https://github.com/htline/SoftHaven/blob/master/Dummy_Info_Fix.sql)

[This is the link to the Vessels DB](https://github.com/htline/SoftHaven/blob/master/VESSEL-1.1.sql)

[This is a link to some dummy data](https://github.com/htline/SoftHaven/blob/master/Dummy_Info.sql)



#### Here are the glassfish resources

![alt text](https://github.com/htline/SoftHaven/blob/master/images/DenmarkTrafficJDBCResource.png "JDBC Resource")
![alt text](https://github.com/htline/SoftHaven/blob/master/images/DenmarkTrafficJDBCConnectionPool.png "JDBC Connection Pool")
![alt text](https://github.com/htline/SoftHaven/blob/master/images/ConnectionPoolProperties.png "Properties")

### Java Build Path

![alt text](https://github.com/htline/SoftHaven/blob/master/images/JavaBuildPath.png "Java Build Path")

## Steps to get set up

Installed Prerequisites: MySQL, JDK 1.8.240 EE, Eclipse, Glassfish

Import project (https://github.com/htline/SoftHaven.git) from git using smart import
