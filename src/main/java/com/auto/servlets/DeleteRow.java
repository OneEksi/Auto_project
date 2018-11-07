package com.auto.servlets;

import com.auto.DAO.DAO;
import com.google.gson.Gson;
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

@WebServlet(name = "DeleteRow")
public class DeleteRow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream sis = request.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(sis));
        String postData = new String();

        while (in.ready())
        {
            postData += in.readLine();

        }
        Gson gson = new Gson();
        JsonObject jo = gson.fromJson(postData,JsonObject.class);
        int tableId=jo.getAsJsonPrimitive("tableId").getAsInt();
        int idel=jo.getAsJsonPrimitive("id").getAsInt();
        MysqlDataSource ds = (MysqlDataSource) request.getServletContext().getAttribute("DBDataSource");
         try {
             DAO.DeleteData(tableId,ds,idel);
         } catch (SQLException e){
             e.printStackTrace();
         }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
