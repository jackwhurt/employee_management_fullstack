-- Setting up tables

-- Employee 'base' table, every Sales employee has a 1 - 1 link to an employee record
CREATE TABLE `Employees` (
    `EmployeeID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
	`Address` varchar(250) NOT NULL,
    `Postcode` varchar(10) NOT NULL,
	`Name` varchar(30) NOT NULL,
	`StartingSalary` decimal(10,2),
	`BankNum` char(17),
	`NIN` char(9),
	`Department` ENUM('Sales', 'HR', 'Talent', 'Finance'),
    PRIMARY KEY (`EmployeeID`)
);

CREATE TABLE `SalesEmployees` (
   	`EmployeeID` smallint NOT NULL UNIQUE,
   	`Commission` decimal(10,2),
   	`TotalSales` decimal(10, 2),
	PRIMARY KEY(`EmployeeID`),
	FOREIGN KEY (`EmployeeID`) REFERENCES Employees(`EmployeeID`)
);

CREATE TABLE `Projects` (
	`ProjectID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
	`ProjectName` varchar(30) UNIQUE,
	PRIMARY KEY (ProjectID)
);

CREATE TABLE `Project_Employees` (
	`ProjectID` smallint NOT NULL,
	`EmployeeID` smallint NOT NULL,
	PRIMARY KEY (`ProjectID`, `EmployeeID`),
	FOREIGN KEY (`EmployeeID`) REFERENCES Employees(`EmployeeID`),
	FOREIGN KEY (`ProjectID`) REFERENCES Projects(`ProjectID`)
);

INSERT INTO Employees (`Name`, Address, Postcode, StartingSalary, Department)
VALUES
('Joe Bloggs', '6 Aberforth road', 'B58 0vx', '10000.00', 'Sales'),
('Jane Doe', '6 Aberforth road', 'B58 0vx', '10000.00', 'Sales'),
('Fred Jones', '6 Aberforth road', 'B58 0vx', '10000.00', 'HR'),
('John Anderson', '6 Aberforth road', 'B58 0vx', '15000.00', 'HR'),
('Mr Jones', '6 Aberforth road', 'B58 0vx', '15000.00', 'Finance'),
('Frank Michaels', '6 Aberforth road', 'B58 0vx', '20000.00', 'Talent');

INSERT INTO SalesEmployees (EmployeeID, Commission, TotalSales)
VALUES
(1, '200.00', '12000.00'),
(2, '100.00', '8000.00');

INSERT INTO Projects (ProjectName)
VALUES
('NHS app'),
('Netflix Processing'),
('Majestic Backend'),
('Random Project'),
('Fake Project'),
('Non-existant project');

INSERT INTO Project_Employees (EmployeeID, ProjectID)
VALUES
('1', '2'),
('1', '1'),
('2', 1),
('3', '1'),
('4', 3),
('5', '6');

