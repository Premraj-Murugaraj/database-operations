package com.db.jdbc.utility;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
    private static volatile DBSingleton instance = null;
    private static volatile Connection conn = null;

    private DBSingleton(){
        try{
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (conn != null){
            throw new RuntimeException("use getConnection() method to create");
        }
        if (instance!= null){
            throw new RuntimeException("use getInstance() method to create");
        }
    }

    public static DBSingleton getInstance(){
        if (instance == null){
            synchronized (DBSingleton.class) {
                if(instance == null){
                    instance = new DBSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        if(conn == null){
            synchronized (DBSingleton.class){
                if (conn == null){
                    try {
                        String dbUrl = "jdbc:mysql://localhost:3306/bigdata";
                        conn = DriverManager.getConnection(dbUrl,"root","root");
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
}
