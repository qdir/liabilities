CREATE DATABASE liabilities;

GRANT ALL ON liabilities.* TO liabilitiesuser@'%' IDENTIFIED BY 'pliabilitiesuser';
GRANT ALL ON liabilities.* TO liabilitiesuser@localhost IDENTIFIED BY 'pliabilitiesuser';

USE liabilities;

CREATE TABLE GenericTransactions (
  	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  	Amount FLOAT (40),
  	TransactionDate datetime,
  	EffectiveDate datetime,
  	Subject VARCHAR(45)
);

CREATE TABLE TransactionHandlers (
	TransactionID BIGINT,
	TransactionHandlerID BIGINT,
	Timestamp VARCHAR(45),
	PRIMARY KEY (TransactionID, TransactionHandlerID),
  	CONSTRAINT `TransactionHandlerID`
    FOREIGN KEY (`TransactionID`)
    REFERENCES GenericTransactions (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
 
);

CREATE TABLE DetailedInformations (
	TransactionID BIGINT,
	DetailedInformationID BIGINT,
	Info VARCHAR(250),
	NonEditable BOOLEAN,
	PRIMARY KEY (TransactionID, DetailedInformationID),
  	CONSTRAINT `DetailedInformationID`
    FOREIGN KEY (`TransactionID`)
    REFERENCES GenericTransactions (ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
 
);