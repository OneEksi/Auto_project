package com.auto.listeners;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseContextLIstener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        MysqlDataSource ds = new MysqlDataSource();
        ds.setDatabaseName("thecarsalon");
        ds.setUser("root");
        ds.setPassword("root");
        context.setAttribute("DBDataSource", ds);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
