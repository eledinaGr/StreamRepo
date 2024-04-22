package com.scytalys.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static final String connectionString = "jdbc:postgresql://127.0.0.1:5432/eshop";
    private static final String dbUser = "dimitris";
    private static final String dbPassword = "@pass0rd@@@";

    private static Connection connection;


    public static Connection getConnection(){
        if (connection == null){
            connection = createConnection();
        }
        return connection;
    }

    private static Connection createConnection(){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            if (conn!=null){
                System.out.println("Connected to the database");
                return conn;
            }else{
                System.out.println("Failed to make connection");
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static int executeQuery (Connection conn, String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted;
    }



}
