package com.auto.servlets;

import com.auto.DAO.DAO;
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
                    list = DAO.getDataAuto(rs);
                    break;
                case 1://
                    list= DAO.getDataCustomer(rs);
                    break;
                case 2://
                    list= DAO.getDataEmployees(rs);
                    break;
                case 3://
                    list = DAO.getDataEmployeeStat(rs);
                    break;
                case 4://
                    list = DAO.getDataSales(rs);
                    break;

            }

            resp.getWriter().append(new Gson().toJson(list));
            resp.getWriter().flush();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

