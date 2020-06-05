package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/t1808a1?serverTimezone=UTC", "root", "");
        }
        return connection;
    }

}
