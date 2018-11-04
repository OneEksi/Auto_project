# Java application for car shop

This example shows how to run Auto project with Java programming language using Maven, Servlets, JDBC, JSP and MySQL.

### Running
To use this sample you must have:

MySQL installed and running, if not please check out [MySQL download page](https://dev.mysql.com/downloads/installer/) and follow [these instructions](http://dev.mysql.com/doc/refman/5.7/en/installing.html).


Navigate to the repository folder:
```
$ cd java-jsp-jdbc-mysql-auto
```

Set up MySQL database, use -u -p flags to provide your user name and password:
```
$  mysql < database_backup.sql
```

Run app
```
 mvn clean install tomcat7:run
```

open browser at http://localhost:8080/


## Workspace
Your workspace should look like:
```
java-jsp-jdbc-mysql-auto/
    src/
        main/
            java/
                com.auto/
                    listeners/
                        DatabaseContextListener.java    # Listener for database
                    models/
                       Auto.java 
                       Customer.java
                       Employees.java
                       EmployeeStat.java
                       Sales.java#    Data model
                    servlets/
                        MainServlet.java
                        ViewTable        # Servlet
                webapp/
                    resources/
                        css/
                            style.css   # css styles
                    WEB-INF/
                        views/
                            index.jsp   # html auto
                    web.xml             # Main web settings
                    
    database_backup.sql     # MySQL database dump
    pom.xml     # project dependencies
    README.md
```

## Technologies
Language - [Java](https://java.com)<br />
Database - [MySQL](https://www.mysql.com/)<br />
Database driver - [JDBC](http://docs.oracle.com/javase/tutorial/jdbc/)<br />
Template - [JSP](http://www.oracle.com/technetwork/java/javaee/jsp/index.html)<br />
Build tool - [Maven](https://maven.apache.org/)



