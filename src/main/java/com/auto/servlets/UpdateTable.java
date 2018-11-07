package com.auto.servlets;

import com.auto.models.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static com.auto.DAO.DAO.SaveDataToDB;


@WebServlet(name = "UpdateTable")
public class UpdateTable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream sis = request.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(sis));
        String postData = new String();

        while (in.ready())
        {
            postData += in.readLine();

        }
        //response.getWriter().append(postData);
        Gson gson = new Gson();
        JsonObject jo = gson.fromJson(postData,JsonObject.class);
        int tableId=jo.getAsJsonPrimitive("tableId").getAsInt();
        JsonElement content = jo.get("content");
        MysqlDataSource ds = (MysqlDataSource) request.getServletContext().getAttribute("DBDataSource");
        //UpdateRequestData urd = a.fromJson(postData,UpdateRequestData.class);
       try{ switch (tableId){
            case 0:
                Auto au = gson.fromJson(content,Auto.class);
                SaveDataToDB(au,ds);
                break;   //создаётся объект класса auto из json, содержащий все поля
            case  1:
                Customer cu =  gson.fromJson(content,Customer.class);
                SaveDataToDB(cu,ds);
                 break;
            case 2:
                Employees em = gson.fromJson(content,Employees.class);
                SaveDataToDB(em,ds);
                break;
            case 3:
                EmployeeStat ems =gson.fromJson(content,EmployeeStat.class);

                response.getWriter().append(String.valueOf(ems.getAmountOfSales()));
                break;
            case 4:
                Sales sl = gson.fromJson(content,Sales.class);
                SaveDataToDB(sl,ds);
                break;
            default:
                break;


        }} catch (SQLException e) {e.printStackTrace();
           response.sendError(500,"Internal server error");}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 response.sendError(405,"Method not allowed");
    }
}
