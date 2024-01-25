package org.maven3.models;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class MySQLconnection {

    Connection connection = null;

    String dbuser = "root";
    String dbpassword = "root";
    String dburl = "jdbc:mysql://localhost:3306/basemaven";


    public Connection getConnection(){
        try {
            //obtener valor del driver
            Class .forName("com.mysql.cj.jdbc.Driver");
            //obtener la conexion
            connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
        } catch (ClassNotFoundException e) {
            System.err.println("a ocurrido un ClassNotFoundException: "+e.getMessage());
        }catch(SQLException e){
            System.err.println("a ocurrido un sql exepction"+e.getMessage());
        }
        return connection;

        

    }
}


