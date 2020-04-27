CREATE DATABASE IF NOT EXISTS DenmarkTraffic;
use DenmarkTraffic;

DROP TABLE IF EXISTS `Quay`;
CREATE TABLE `Quay`(
	`Id` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(64) NOT NULL,
    `PortName` VARCHAR(64) NOT NULL,
    `Type` VARCHAR(32) NOT NULL,
    `Length` SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY (Id)
);

DROP TABLE IF EXISTS `Berth`;
CREATE TABLE `Berth`(
	`Id` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(16) NOT NULL,
    `QuayId` INT NOT NULL,
    `Available` BOOLEAN NOT NULL DEFAULT TRUE,
	PRIMARY KEY (Id),
    FOREIGN KEY(`QuayId`) REFERENCES `Quay`(`Id`)
);

DROP TABLE IF EXISTS `Ship`;
CREATE TABLE `Ship`(
	`IMO` MEDIUMINT UNSIGNED NOT NULL,
	`Name` VARCHAR(128) NOT NULL,
	`Berth` INT,
	`State` VARCHAR(24) NOT NULL,
	PRIMARY KEY (IMO),
    FOREIGN KEY (`Berth`) REFERENCES `Berth`(`Id`)
);

DROP TABLE IF EXISTS `Vessel Pre-arrival Form`;
CREATE TABLE `Vessel Pre-arrival Form`(
	`Ship name` VARCHAR(32) NOT NULL,
	`Call sign` VARCHAR(32) NOT NULL,
	`IMO` INT NOT NULL,
	`Agent Info` VARCHAR(64) NOT NULL,
	`Arriving Form` VARCHAR(32) NOT NULL,
	`ETA` DATETIME NOT NULL,
	`Berth Number` INT NOT NULL,
	`Next PortName` VARCHAR(32) NOT NULL,
	`ETD` DATETIME NOT NULL,
	`Offboarding Cargo Desc` VARCHAR(64) NOT NULL,
	`Offboarding Cargo Amount` INT,
	`Onboarding Cargo Desc` VARCHAR(64),
	`Onboarding Cargo Amount` INT,
	`Passengers on Arrival` INT,
	`Passengers on Departure` INT,
	`Crew Documents` BLOB,
	`Form Validation` INT,
	PRIMARY KEY (IMO)
	);
	
DROP TABLE IF EXISTS `Berthing Record`;
CREATE TABLE `Berthing Record`(
	`IMO Number` INT NOT NULL,
	`Quay` VARCHAR(32),
	`Berth Numbers` INT, 
	`ETA` DATETIME,
	`ATA` DATETIME,
	`ETD` DATETIME,
	`ATD` DATETIME,
	`Status` INT NOT NULL
	);
		
DROP TABLE IF EXISTS `Port Table`;
CREATE TABLE `Port Table`(
	`Port` VARCHAR(32) NOT NULL,
	`Quay` VARCHAR(32) DEFAULT NULL,
	`Type` VARCHAR(32) DEFAULT NULL,
	`Length` INT DEFAULT NULL,
	`Berth` INT DEFAULT NULL,
	FOREIGN KEY (`Berth`) REFERENCES `Berth`(`Id`)
	
);

-- Need to figure out AIS Messages -- 


	
	
	
	
	
    
	


