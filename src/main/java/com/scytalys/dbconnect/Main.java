package com.scytalys.dbconnect;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionSingleton.getConnection();

        String dropTableCommand = "DROP TABLE IF EXISTS product";
        String createTableCommand = "CREATE TABLE IF NOT EXISTS product (id serial primary key, name varchar(50))";
        String insertCommand = "INSERT INTO product (name ) VALUES(? )";


        System.out.println(ConnectionSingleton.executeQuery(connection, dropTableCommand));
        System.out.println(ConnectionSingleton.executeQuery(connection, createTableCommand));

        PreparedStatement preparedStatement = connection.prepareStatement(insertCommand);
        preparedStatement.setString(1, "chips");


        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println(rowsInserted + " row(s) inserted. ");


        // read

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");

        while (resultSet.next()){
            String columnValue = resultSet.getString("name");
            System.out.println( "Column value "+ columnValue);

        }



    }
}
