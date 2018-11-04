package com.auto.servlets;

import com.auto.models.*;
import com.google.gson.Gson;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
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

public class MainServlet extends HttpServlet {


    @Override//обраб Get запрос
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

    }





}
