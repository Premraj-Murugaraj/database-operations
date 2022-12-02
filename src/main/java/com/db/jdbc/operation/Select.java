package com.db.jdbc.operation;

import com.db.jdbc.DBOperation;
import com.db.jdbc.DataBase;
import com.db.jdbc.utility.DBSingleton;

import java.sql.*;

public class Select extends DataBase {

    DBSingleton instance = DBSingleton.getInstance();
    Connection conn = instance.getConnection();

    @Override
    public void executeDB() {
        try {
            String sqlSelectQuery = "select * from people";
            PreparedStatement pstmt = conn.prepareStatement(sqlSelectQuery);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName =  resultSet.getString("firstName");
                String lastName =  resultSet.getString("lastName");
                int age =  resultSet.getInt("age");
                System.out.println(id + "\t" + firstName + "\t" + lastName + "\t" + age);
            }
            System.out.println("Displayed All records present in the table !!!!");


        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
