package com.auto.servlets;

import com.auto.models.*;
import com.google.gson.Gson;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewTable")
public class ViewTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlDataSource ds = (MysqlDataSource) req.getServletContext().getAttribute("DBDataSource");
        String strTableId = req.getParameter("t");
        String tableName;
        String[] tables = {"auto", "customer", "employees", "new_view", "sales"};//имена таблиц
        int tableId = 0;
        if (null != strTableId && !strTableId.isEmpty()) {
            tableId = Integer.parseInt(strTableId);
        }
        tableName = tables[tableId];
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM %s ", tableName))) {//защита от sql инъекций
            List list = null;
            switch (tableId) {
                case 0://Auto
                    list = getDataAuto(rs);
                    break;
                case 1://
                    list= getDataCustomer(rs);
                    break;
                case 2://
                    list= getDataEmployees(rs);
                    break;
                case 3://
                    list = getDataEmployeeStat(rs);
                    break;
                case 4://
                    list = getDataSales(rs);
                    break;

            }

            // Extract data from result set

            //req.setAttribute("chartData", new Gson().toJson(list));
            //req.setAttribute("chartTitle", "TheCarSalon");
            resp.getWriter().append(new Gson().toJson(list));
            resp.getWriter().flush();
          //  req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<Auto> getDataAuto (ResultSet rs) throws SQLException{
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
    private List<Customer> getDataCustomer (ResultSet rs) throws SQLException{
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
    private List<Employees> getDataEmployees (ResultSet rs) throws SQLException{
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
    private List<Sales> getDataSales (ResultSet rs) throws SQLException{
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
    private List<EmployeeStat> getDataEmployeeStat (ResultSet rs) throws SQLException{
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





}

