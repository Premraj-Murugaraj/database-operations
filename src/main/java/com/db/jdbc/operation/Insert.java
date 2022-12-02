package com.db.jdbc.operation;

import com.db.jdbc.DataBase;
import com.db.jdbc.utility.DBSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Insert extends DataBase {

    Scanner scanner = null;

    DBSingleton instance = DBSingleton.getInstance();
    Connection conn = instance.getConnection();

    @Override
    public void executeDB() {

        scanner = new Scanner(System.in);

        System.out.println("Enter first name :: ");
        String firstName = scanner.next();

        System.out.println("Enter last name :: ");
        String lastName = scanner.next();

        System.out.println("Enter age :: ");
        int age = scanner.nextInt();

        try{

            String sqlInsertQuery = "insert into people(`firstName`,`lastName`,`age`) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsertQuery);

            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setInt(3,age);

            int rowCount = pstmt.executeUpdate();

            System.out.println("Insertion is success :: "+rowCount);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
