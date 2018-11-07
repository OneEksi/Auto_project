package com.auto.DAO;

import com.auto.models.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public  static  List<Auto> getDataAuto (ResultSet rs) throws SQLException {
        List<Auto> auto = new ArrayList<Auto>();
        while (rs.next()) {
            //Retrieve by column name
            int idAuto = rs.getInt("idAuto");
            int cost = rs.getInt("Cost");
            String model = rs.getString("Model");
            double engineCapacity = rs.getDouble("EngineCapacity");
            double enginePower = rs.getDouble("EnginePower");
            String typeOfShell = rs.getString("TypeOfShell");
            String fuelType = rs.getString("FuelType");
            String driveUnit = rs.getString("DriveUnit");
            double accelerationTime = rs.getDouble("AccelerationTime");

            // Add item
            auto.add(new Auto(idAuto,model,engineCapacity,enginePower,
                    typeOfShell,fuelType,accelerationTime,driveUnit,cost));
        }
        return  auto;

    }
    public static List<Customer> getDataCustomer (ResultSet rs) throws SQLException{
        List<Customer> customer = new ArrayList<Customer>();
        while (rs.next()) {
            //Retrieve by column name
            int idCustomer = rs.getInt("idCustomer");
            String lastName = rs.getString("LastName");
            String firstName = rs.getString("FirstName");
            String middleName = rs.getString("MiddleName");
            String contTel = rs.getString("ContTel");
            String address = rs.getString("Address");


            // Add item
            customer.add(new Customer(idCustomer,lastName,firstName,middleName,contTel,address));
        }
        return  customer;

    }
    public static  List<Employees> getDataEmployees (ResultSet rs) throws SQLException{
        List<Employees> employee = new ArrayList<Employees>();
        while (rs.next()) {
            //Retrieve by column name
            int idEmployee = rs.getInt("idEmployee");
            String lastName = rs.getString("LastName");
            String firstName = rs.getString("FirstName");
            String middleName = rs.getString("MiddleName");
            String contTel = rs.getString("ContTel");
            String address = rs.getString("Address");
            double experience = rs.getDouble("Experience");


            // Add item
            employee.add(new Employees(idEmployee,lastName,firstName,middleName,contTel,address,experience));
        }
        return  employee;

    }
    public static List<Sales> getDataSales (ResultSet rs) throws SQLException{
        List<Sales> sales = new ArrayList<Sales>();
        while (rs.next()) {
            //Retrieve by column name
            int idSales = rs.getInt("idSales");
            int idCustomer = rs.getInt("idCustomer");
            int idAuto = rs.getInt("idAuto");
            int idEmployee = rs.getInt("idEmployee");
            String saleDate = rs.getString("SaleDate");


            // Add item
            sales.add(new Sales(idSales,idCustomer,idAuto,idEmployee,saleDate));
        }
        return  sales;

    }
    public static List<EmployeeStat> getDataEmployeeStat (ResultSet rs) throws SQLException{
        List<EmployeeStat> employeeStats = new ArrayList<EmployeeStat>();
        while (rs.next()) {
            //Retrieve by column name

            int idEmployee = rs.getInt("idEmployee");
            int NumberOfSales = rs.getInt("NumberOfSales");
            int AmountOfSales = rs.getInt("AmountOfSales");



            // Add item
            employeeStats.add(new EmployeeStat(idEmployee,NumberOfSales,AmountOfSales));
        }
        return  employeeStats;

    }

     private  static  String[] tables = {"auto", "customer", "employees", "new_view", "sales"};//имена таблиц
     public static void SaveDataToDB (Auto data, MysqlDataSource ds) throws  SQLException{
         Connection conn = ds.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(String.format(
                 "REPLACE INTO Auto SET idAuto =%d,Model = \"%s\", EngineCapacity = %f," +
                         "EnginePower = %f,TypeOfShell = \"%s\",FuelType = \"%s\",AccelerationTime = %f," +
                         "DriveUnit = \"%s\",Cost = %d",data.getIdAuto(),data.getModel(), data.getEngineCapacity(),
                         data.getEnginePower(),data.getTypeOfShell(),data.getFuelType(),data.getAccelerationTime(),
                 data.getDriveUnit(), data.getCost()));
             
         }
        
         
    public static void SaveDataToDB (Employees data, MysqlDataSource ds) throws SQLException{
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
                   ResultSet rs = stmt.executeQuery(String.format(
                    "REPLACE INTO Employees SET idEmployee =%d, LastName = \"%s\",FirstName= \"%s\",MiddleName= \"%s\"," +
                            "ContTel= \"%s\",Address= \"%s\", Experience =\"%s\"", data.getIdEmployee(),data.getLastName(),
                           data.getFirstName(),data.getMiddleName(), data.getContTel(),
                           data.getAddress(),data.getExperience()));
        }
    

    public static void SaveDataToDB (Sales data, MysqlDataSource ds) throws SQLException{
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(String.format(
                "REPLACE INTO Sales SET idSales =%d, idCustomer =%d,idAuto=%d,idEmployee=%d,SaleDate=\"%s\"",data.getIdSales(),
                data.getIdCustomer(),
                data.getIdAuto(),data.getIdEmployee(),data.getSaleDate()));
    }

    public static void SaveDataToDB (Customer data, MysqlDataSource ds) throws SQLException{
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(String.format(
             "REPLACE INTO  Customer SET idCustomer =%d, LastName = \"%s\",FirstName= \"%s\",MiddleName= \"%s\"," +
                     "ContTel= \"%s\",Address= \"%s\"",data.getIdCustomer(),data.getLastName(), data.getFirstName(),
                data.getMiddleName(),data.getContTel(),data.getAddress()));
    }

    public  static  void  DeleteData (int tableId,MysqlDataSource ds,int idel) throws  SQLException{

        String [] idnames = {"idAuto","idCustomer","idEmployees","","idSales"};
        if (tableId == 3) {
            return;
        }
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        System.out.println( String.format("DELETE  FROM %s WHERE %s=%d",tables[tableId],idnames[tableId],idel));
        stmt.executeUpdate(String.format("DELETE  FROM %s WHERE %s=%d",
                tables[tableId],idnames[tableId],idel));

    }

}
