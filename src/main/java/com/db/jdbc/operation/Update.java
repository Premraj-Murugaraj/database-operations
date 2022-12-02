package com.db.jdbc.operation;

import com.db.jdbc.DataBase;
import com.db.jdbc.utility.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update extends DataBase {

    DBSingleton instance = DBSingleton.getInstance();
    Connection conn = instance.getConnection();
    @Override
    public void executeDB() {
        Select select = new Select();

        select.executeDB();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id of the record to modify :: ");
        int id = scanner.nextInt();

        System.out.println("Enter column name to update :: ");
        String columnName = scanner.next();

        System.out.println("Enter Data to update :: ");
        String fieldValue = scanner.next();

        try{
            String sqlQuery = "update people set "+columnName+" = ? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
            if (columnName.equalsIgnoreCase("age")){
                Integer sAge = Integer.parseInt(fieldValue);
                pstmt.setInt(1,sAge);

            } else if (columnName.equalsIgnoreCase("firstname") || columnName.equalsIgnoreCase("lastname")) {
                pstmt.setString(1,fieldValue);
            } else {
                throw new RuntimeException("operation not supported");
            }
            pstmt.setInt(2,id);

            int rowCount = pstmt.executeUpdate();

            System.out.println("Update is success :: "+rowCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Table Displayed after Update operation");
        select.executeDB();

    }
}
