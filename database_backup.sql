CREATE DATABASE IF NOT EXISTS thecarsalon;
USE thecarsalon;
DROP PROCEDURE IF EXISTS init;
DROP PROCEDURE IF EXISTS init1;
DROP PROCEDURE IF EXISTS init2;
DROP PROCEDURE IF EXISTS init3;

DELIMITER //


CREATE PROCEDURE init ()
LANGUAGE SQL
  BEGIN
    DECLARE user_exist, data_present INT;
    SET user_exist = (SELECT EXISTS (SELECT DISTINCT user FROM mysql.user WHERE user = "root"));
    IF user_exist = 0 THEN
      CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
      GRANT ALL PRIVILEGES ON anychart_db.* TO 'root'@'localhost';
      FLUSH PRIVILEGES;
    END IF;
    CREATE TABLE IF NOT EXISTS auto (
      idAuto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
      Model VARCHAR(45) NOT NULL,
      EngineCapacity decimal(6,1) NOT NULL,
      EnginePower decimal(6,0) NOT NULL,
      TypeOfShell varchar(45) NOT NULL,
   FuelType varchar(45) NOT NULL,
   AccelerationTime decimal(6,1) NOT NULL,
   DriveUnit varchar(45) NOT NULL,
   Cost int(11) NOT NULL
	);
    SET data_present = (SELECT COUNT(*) FROM auto);
    IF data_present = 0 THEN
      INSERT INTO auto (idAuto,Model,EngineCapacity,EnginePower,TypeOfShell,FuelType,AccelerationTime,DriveUnit,Cost) VALUES
        (1,'Acura TLX',2.4,208,'sedan','benzine-95',8.2,'Front-wheel drive',31804),
        (4,'Cadillac CTS-V',6.2,649,'sedan','benzine-98',3.7,'Rear drive',90000),
        (5,'Porsche 911 GT3',3.8,435,'coupe','benzine-98',4.1,'Rear drive',175992),
        (6,'Alfa Romeo 4C',1.7,240,'coupe','benzine-95',4.5,'Rear drive',55043),
        (7,'Maserati Levante S3.0',2.9,430,'SUV','benzine-95',5.2,'all wheel drive',101460),
        (8,'Ferrari LaFerrari Aperta',6.3,963,'Roadster','benzine-95',2.8,'Rear drive',1261978);
    END IF;
    END;//





DELIMITER //
CREATE PROCEDURE init1()
LANGUAGE SQL
  BEGIN
    DECLARE  data_present1 INT;
 CREATE TABLE IF NOT EXISTS customer (
      idCustomer INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  LastName varchar(45) NOT NULL,
      FirstName varchar(45) NOT NULL,
      MiddleName varchar(45) NOT NULL,
      ContTel varchar(45) NOT NULL,
      Address varchar(145) NOT NULL
	);
    SET data_present1 = (SELECT COUNT(*) FROM customer);
    IF data_present1 = 0 THEN
      INSERT INTO customer (idCustomer,LastName,FirstName,MiddleName,ContTel,Address) VALUES
        (1,'Anufrieva','Elizaveta','Gennadievna','33-371-06-03','San Francisco,st.Park Presidio Boulevard,h.1392'),
        (2,'Kusniatsova','Victoria','Gennadievna','33-989-98-99','San Francisco,Van Ness Avenue,h.78');
    END IF;
    END;//



DELIMITER //
CREATE PROCEDURE init2 ()
LANGUAGE SQL
  BEGIN
    DECLARE  data_present2 INT;
 CREATE TABLE IF NOT EXISTS employees (
      idEmployee INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  LastName varchar(45) NOT NULL,
      FirstName varchar(45) NOT NULL,
      MiddleName varchar(45) NOT NULL,
      ContTel varchar(45) NOT NULL,
      Address varchar(145) NOT NULL,
      Experience decimal(45,1) NOT NULL
	);
    SET data_present2 = (SELECT COUNT(*) FROM employees);
    IF data_present2 = 0 THEN
      INSERT INTO employees (idEmployee,LastName,FirstName,MiddleName,ContTel,Address,Experience) VALUES
        (1,'Petrov','Vadim','Sergeevich','29-891-34-87','San Francisco,Van Ness Avenue,h.31',4.0),
         (2,'Kireev','Anton','Igorevich','23-452-71-31','San Francisco,Van Ness Avenue,h.31',1.0),
         (3,'Kabakova','Marina','Sergeevna','41-265-48-78','San Francisco,Van Ness Avenue,h.31',6.4);
    END IF;
    END;//


DELIMITER //

CREATE PROCEDURE init3 ()
LANGUAGE SQL
  BEGIN
    DECLARE  data_present3 INT;
 CREATE TABLE  sales (
      idSales int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
   idCustomer int(11) NOT NULL ,
   idAuto int(11) NOT NULL ,
   idEmployee int(11) NOT NULL ,
   SaleDate date NOT NULL,
    CONSTRAINT sales_ibfk_1 FOREIGN KEY (idCustomer) REFERENCES customer (idCustomer),
   CONSTRAINT sales_ibfk_2 FOREIGN KEY (idAuto) REFERENCES auto (idAuto),
   CONSTRAINT sales_ibfk_3 FOREIGN KEY (idEmployee) REFERENCES employees (idEmployee)
	);

    SET data_present3 = (SELECT COUNT(*) FROM sales);
    IF data_present3 = 0 THEN
      INSERT INTO sales (idSales,idCustomer,idAuto,idEmployee,SaleDate) VALUES
        (1,1,6,3,'2018-06-17'),
         (3,2,4,2,'2018-04-13'),
         (4,2,8,2,'2018-11-02');
    END IF;
    END;//
    #RUN PROCEDURES
    CALL init();
    CALL init1();
    CALL init2();
    CALL init3();

    CREATE or replace VIEW new_view  AS(
      select sales.idEmployee AS idEmployee,
      count(sales.idSales) AS NumberOfSales,
      sum(auto.Cost) AS AmountOfSales
      from sales join auto on sales.idAuto = auto.idAuto
      group by sales.idEmployee
	);




