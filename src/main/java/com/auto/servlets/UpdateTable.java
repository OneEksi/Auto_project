package com.auto.servlets;

import com.auto.models.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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

        //UpdateRequestData urd = a.fromJson(postData,UpdateRequestData.class);
        switch (tableId){
            case 0:
                Auto au = gson.fromJson(content,Auto.class);

                break;   //создаётся объект класса auto из json, содержащий все поля
            case  1:
                Customer cu =  gson.fromJson(content,Customer.class);
                 break;
            case 2:
                Employees em = gson.fromJson(content,Employees.class);
                break;
            case 3:
                EmployeeStat ems =gson.fromJson(content,EmployeeStat.class);
                response.getWriter().append(String.valueOf(ems.getAmountOfSales()));
                break;
            case 4:
                Sales sl = gson.fromJson(content,Sales.class);
                break;
            default:
                break;


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 response.sendError(405,"Method not allowed");
    }
}
