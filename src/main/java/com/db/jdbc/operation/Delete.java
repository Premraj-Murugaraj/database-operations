package com.db.jdbc.operation;

import com.db.jdbc.DataBase;
import com.db.jdbc.utility.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete extends DataBase {

    DBSingleton instance = DBSingleton.getInstance();
    Connection conn = instance.getConnection();

    @Override
    public void executeDB() {
        Select select = new Select();
        select.executeDB();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id of the record to delete :: ");
        int id = scanner.nextInt();


        try{
            String sqlQuery = "delete from people where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery);

            pstmt.setInt(1,id);

            int rowCount = pstmt.executeUpdate();

            System.out.println("Delete is success :: "+rowCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Table Displayed after Delete operation");
        select.executeDB();
    }
}
